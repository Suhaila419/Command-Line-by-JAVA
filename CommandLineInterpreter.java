import java.io.*;
import java.util.ArrayList;

public class CommandLineInterpreter {

    public CommandLineInterpreter() {
    }

    public String pwd() {
        return System.getProperty("user.dir");
    }

    public void cd(String newDirectory) {
        String currDirectory = System.getProperty("user.dir");
        File dir;
        if (new File(newDirectory).isAbsolute()) {
            // Absolute path
            dir = new File(newDirectory);
        } else {
            // Relative path based on the current directory
            dir = new File(currDirectory, newDirectory);
        }

        if (dir.exists() && dir.isDirectory()) {
            try {
                // Resolve the canonical path to handle cases with "../" or "./"
                String newPath = dir.getCanonicalPath();
                System.setProperty("user.dir", newPath);
            } catch (IOException e) {
                System.out.println("Error: Could not resolve directory path.");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }


    public void mkdir(String[] Dirs) { //remove print statements
        if (Dirs.length > 0) {
            for (int i = 0; i < Dirs.length; i++) {
                if (Dirs[i] == "|") {
                    break;
                }
                String dir = Dirs[i];
                File newDirectory;
                if (new File(dir).isAbsolute()) {
                    newDirectory = new File(dir);
                } else {
                    newDirectory = new File(System.getProperty("user.dir"), dir);

                }
                if (!newDirectory.exists()) {
                    newDirectory.mkdirs();
                } else {
                    System.out.println("Directory already exists");
                }
            }

        } else {
            System.out.println("Please specify a directory name.");
        }


    }

    public void rmdir(String[] Dirs) { //remove print statements
        if (Dirs.length > 0) {
            for (int i = 0; i < Dirs.length; i++) {
                if (Dirs[i] == "|") {
                    break;
                }
                String dir = Dirs[i];
                File dir2remove;
                if (new File(dir).isAbsolute()) {
                    // absolute path
                    dir2remove = new File(dir);
                } else {
                    // relative path
                    dir2remove = new File(System.getProperty("user.dir"), dir);
                }
                if (dir2remove.exists() && dir2remove.isDirectory()) {
                    if (dir2remove.listFiles().length == 0)
                        dir2remove.delete();
                    else
                        System.out.println("Directory contains files");
                } else {
                    System.out.println("Directory does not exist");
                }
            }
        } else {
            System.out.println("Please specify a directory name.");
        }
    }

    void touch(String [] files) {
        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == "|") {
                    break;
                }
                String file = files[i];
                File newFile;
                if (new File(file).isAbsolute()) {
                    // absolute path
                    newFile = new File(file);
                } else {
                    // relative path
                    newFile = new File(System.getProperty("user.dir"), file);
                }
                try {
                    if (!newFile.exists()) {
                        FileWriter writer = new FileWriter(newFile);
                    } else
                        System.out.println("File already exists");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }

    }

    public ArrayList<String> ls(String dir) {
        File directory = new File(dir);
        ArrayList<String> AllFile = new ArrayList<>();
        // Print all file and Without hidden file
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            System.out.println("Print ALL Files and Folders (without hidden file):");
            if (files != null) {
                for (File file : files) {
                    if (file.isHidden()) {
                        continue;
                    } else {
                        AllFile.add(file.getName());
                    }
                }
            } else {
                String message = "The directory is empty.";
                AllFile.add(message);
            }
        } else {
            String messaage = "Error: Could not open Directory";
            AllFile.add(messaage);
        }
        return (AllFile);
    }

    public ArrayList<String> ls_r(String dir) {
        File directory = new File(dir);
        // Print all file reverse and without hidden file
        ArrayList<String> AllFileReverse = new ArrayList<>();
        ArrayList<String> fileReverse = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            System.out.println("Print ALL Files Reverse and Folders (Without hidden):");
            if (files != null) {
                for (File file : files) {
                    if (file.isHidden()) {
                        continue;
                    } else {
                        fileReverse.add(file.getName());
                    }
                }
                for (int i = fileReverse.size() - 1; i >= 0; i--) {
                    if (fileReverse != null)
                        AllFileReverse.add(fileReverse.get(i));
                }
            } else {
                String message = "The directory is empty.";
                AllFileReverse.add(message);
            }
        } else {
            String message = "Error: Could not open Directory";
            AllFileReverse.add(message);
        }
        return (AllFileReverse);
    }

    public ArrayList<String> ls_a(String currentPath) {
        File directory = new File(currentPath);
        // Print all file and hidden file
        ArrayList<String> AllFile = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            System.out.println("Print ALL Files and Folders (including hidden):");
            if (files != null) {
                for (File file : files) {
                    if (file.isHidden()) {
                        AllFile.add("(Hidden) " + file.getName());
                    } else {
                        AllFile.add(file.getName());
                    }
                }
            } else {
                String message = "The directory is empty.";
                AllFile.add(message);
            }
        } else {
            String message = "Error: Could not open Directory";
            AllFile.add(message);
        }
        return (AllFile);
    }

    public ArrayList<String> help() {
        ArrayList<String> content = new ArrayList<>();
        File file;
        file = new File(System.getProperty("user.dir"), "help.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error in reading file: " + e.getMessage());
        }
        return content;
    }

    public String executePipeCommand(String command1, String command2) {
        String output = executeCommand(command1); // Execute the first command
        return executeCommandWithInput(command2, output); // Pass the output to the second command
    }

    public String executeCommand(String command) {
        switch (command.trim()) {
            case "ls":
                return String.join("\n", ls(pwd()));
            case "pwd":
                return pwd();
            // Add other commands as needed
            default:
                return "Command not found!";
        }
    }

    public String executeCommandWithInput(String command, String input) {
        if (command.equals("cat")) {
            return input; // The 'cat' command just displays the content
        }
        // Handle other commands that require input
        return "Command not found!";
    }

    public String executeAppendToFile(String content, String fileName) {
        File file;
        if (new File(fileName).isAbsolute()) {
            // absolute path
            file = new File(fileName);
        } else {
            // relative path
            file = new File(System.getProperty("user.dir"), fileName);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content + "\n");
            return "Content appended successfully to " + fileName;
        } catch (IOException e) {
            return "Error: Could not write to file.";
        }
    }

    public ArrayList<String> cat(String filePath) { //not working with redirection
        ArrayList<String> content = new ArrayList<>();
        File file;
        if (new File(filePath).isAbsolute()) {
            // absolute path
            file = new File(filePath);
        } else {
            // relative path
            file = new File(System.getProperty("user.dir"), filePath);
        }
        if (!file.exists()) {
            return content;
        }
        if (!file.canRead()) {
            content.add("File is not readable");
            return content;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error in reading file: " + e.getMessage());
        }
        return content;
    }

    public void mv(String [] sourcePaths, String destinationPath) { // need to handle moving more than one file
        File destinationFile;
        if (new File(destinationPath).isAbsolute()) {
            // absolute path
            destinationFile = new File(destinationPath);
        } else {
            // relative path
            destinationFile = new File(System.getProperty("user.dir"), destinationPath);
        }
        for (int i = 0; i < sourcePaths.length; i++) {
            File sourceFile;
            if (new File(sourcePaths[i]).isAbsolute()) {
                // absolute path
                sourceFile = new File(sourcePaths[i]);
            } else {
                // relative path
                sourceFile = new File(System.getProperty("user.dir"), sourcePaths[i]);
            }

            if (!sourceFile.exists()) {
                System.out.println("  error-Source file does not exist ");
                return;
            }
            File movedFile = new File(destinationFile, "");
            if (destinationFile.exists()) {
                if(destinationFile.isDirectory()) {
                    movedFile = new File(destinationFile, sourceFile.getName());
                }
                else
                    System.out.println("Warning- Destination file already exists.");
            }

            boolean success = sourceFile.renameTo(movedFile);
            if (!success) {
                System.out.println("Error moving file.");
            } else {
                System.out.println("File is moved successfully.");
            }
        }
    }

    public String writeToFile(String content, String fileName) {
        File file;
        if (new File(fileName).isAbsolute()) {
            // absolute path
            file = new File(fileName);
        } else {
            // relative path
            file = new File(System.getProperty("user.dir"), fileName);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(content + "\n");
            return "Content overwritten successfully to " + fileName;
        } catch (IOException e) {
            return "Error: Could not write to file.";
        }
    }

    public void rm(String [] files) {
        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == "|") {
                    break;
                }
                String file = files[i];
                File toBeRemovedFile;
                if (new File(file).isAbsolute()) {
                    // absolute path
                    toBeRemovedFile = new File(file);
                } else {
                    // relative path
                    toBeRemovedFile = new File(System.getProperty("user.dir"), file);
                }

                if (!toBeRemovedFile.exists()) {
                    System.out.println("\"" + file + "\" does not exist.");
                    return;
                }

                if (!toBeRemovedFile.delete()) {
                    System.out.println("Error: Unable to delete file");
                } else {
                    System.out.println("File is deleted successfully.");
                }
            }
        }
        else
            System.out.println("Specify files to be deleted.");

    }

}



