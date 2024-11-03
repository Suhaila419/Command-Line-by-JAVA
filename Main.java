import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        Scanner scanner = new Scanner(System.in);
        String command;
        String previousCommandOutput = "";

        while (true) {
            System.out.print(cli.pwd() + "> ");
            command = scanner.nextLine();

            if (command.contains("|")) {
                String[] pipeCommands = command.split("\\|");
                String command1 = pipeCommands[0].trim();
                String command2 = pipeCommands[1].trim();

                String result = cli.executePipeCommand(command1, command2);
                System.out.println(result);
                previousCommandOutput = result;

            } else if (command.contains(">>")) {
                String[] parts = command.split(">>");
                String actualCommand = parts[0].trim();
                String filePath = parts[1].trim();

                String[] tokens = actualCommand.split(" ");

                if (tokens[0].equals("ls")) {
                    ArrayList<String> files;
                    if (tokens.length > 1) {
                        switch (tokens[1]) {
                            case "-r":
                                files = cli.ls_r(tokens.length > 2 ? tokens[2] : cli.pwd());
                                break;
                            case "-a":
                                files = cli.ls_a(tokens.length > 2 ? tokens[2] : cli.pwd());
                                break;
                            default:
                                files = cli.ls(tokens[1]);
                                break;
                        }
                    } else {
                        files = cli.ls(cli.pwd());
                    }

                    if (files != null) {
                        files.forEach(System.out::println);
                        previousCommandOutput = String.join("\n", files);
                    }

                    if (!previousCommandOutput.isEmpty()) {
                        String result = cli.executeAppendToFile(previousCommandOutput, filePath);
                        System.out.println(result);
                    }
                }
                else if (tokens[0].equals("cat")) {
                    // New cat handling code
                    ArrayList<String> fileContents = cli.cat(tokens[1]);
                    if (!fileContents.isEmpty()) {
                        previousCommandOutput = String.join("\n", fileContents);
                        String result = cli.executeAppendToFile(previousCommandOutput, filePath);
                        System.out.println(result);
                    }
                }
                else {
                    System.out.println("Unsupported command for redirection");
                }
            }
            else if (command.contains(">")) {
                String[] parts = command.split(">");
                String actualCommand = parts[0].trim();
                String filePath = parts[1].trim();

                String[] tokens = actualCommand.split(" ");

                if (tokens[0].equals("ls")) {
                    ArrayList<String> files;
                    if (tokens.length > 1) {
                        switch (tokens[1]) {
                            case "-r":
                                files = cli.ls_r(tokens.length > 2 ? tokens[2] : cli.pwd());
                                break;
                            case "-a":
                                files = cli.ls_a(tokens.length > 2 ? tokens[2] : cli.pwd());
                                break;
                            default:
                                files = cli.ls(tokens[1]);
                                break;
                        }
                    } else {
                        files = cli.ls(cli.pwd());
                    }

                    if (files != null) {
                        files.forEach(System.out::println);
                        previousCommandOutput = String.join("\n", files);
                    }

                    if (!previousCommandOutput.isEmpty()) {
                        String result = cli.writeToFile(previousCommandOutput, filePath);
                        System.out.println(result);
                    }
                }
                else if (tokens[0].equals("cat")) {
                    // New cat handling code
                    ArrayList<String> fileContents = cli.cat(tokens[1]);
                    if (!fileContents.isEmpty()) {
                        previousCommandOutput = String.join("\n", fileContents);
                        String result = cli.writeToFile(previousCommandOutput, filePath);
                        System.out.println(result);
                    }
                }
                else {
                    System.out.println("Unsupported command for redirection");
                }
            }
            else {
                String[] tokens = command.split(" ");
                String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);

                switch (tokens[0]) {
                    case "cd":
                        if (tokens.length > 1) {
                            cli.cd(tokens[1]);
                        } else {
                            System.out.println("Please specify a directory name.");
                        }
                        break;
                    case "ls":
                        ArrayList<String> files;
                        if (tokens.length > 1) {
                            switch (tokens[1]) {
                                case "-r":
                                    files = cli.ls_r(tokens.length > 2 ? tokens[2] : cli.pwd());
                                    break;
                                case "-a":
                                    files = cli.ls_a(tokens.length > 2 ? tokens[2] : cli.pwd());
                                    break;
                                default:
                                    files = cli.ls(tokens[1]);
                                    break;
                            }
                        } else {
                            files = cli.ls(cli.pwd());
                        }
                        if (files != null) {
                            files.forEach(System.out::println);
                            previousCommandOutput = String.join("\n", files);
                        }
                        break;
                    case "pwd":
                        String currentPath = cli.pwd();
                        System.out.println(currentPath);
                        previousCommandOutput = currentPath;
                        break;
                    case "mkdir":
                        cli.mkdir(arguments);
                        break;
                    case "rmdir":
                        cli.rmdir(arguments);
                        break;
                    case "touch":
                        cli.touch(arguments);
                        break;
                    case "cat":
                        ArrayList <String> content = cli.cat(tokens[1]);
                        if (content != null) {
                            content.forEach(System.out::println);
                            previousCommandOutput = String.join("\n", content);
                        }
                        break;
                    case "rm":
                        cli.rm(arguments);
                        break;
                    case "mv":
                        String[] toBeMovedFiles = Arrays.copyOfRange(arguments, 0, arguments.length - 1);
                        String destination = arguments[arguments.length - 1];
                        cli.mv(toBeMovedFiles,destination);
                        break;
                    case "help":
                        ArrayList <String> help = cli.help();
                        if (help != null) {
                            help.forEach(System.out::println);
                            previousCommandOutput = String.join("\n", help);
                        }
                        break;
                    case "exit":
                        scanner.close();
                        return;
                    default:
                        System.out.println(tokens[0] + ": command not found...");
                }
            }
        }
    }
}