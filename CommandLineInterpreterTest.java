//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.File;
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//public class CommandLineInterpreterTest {
//
//    @BeforeEach
//    public void setUp() {
//        File currneDirectory = new File(System.getProperty("user.dir"));
//        System.setProperty("user.dir", currneDirectory.getAbsolutePath());
//    }
//    @Test
//    public void testPWD1(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        assertEquals(System.getProperty("user.dir"),c.pwd());
//    }
//    @Test
//    public void testPWD2(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        assertFalse(c.pwd() == "D:\\java\\cmd" );
//    }
////    @Test
////    public void testPWD3(){
////        CommandLineInterpreter c=new CommandLineInterpreter();
////        File currneDirectory = new File(System.getProperty("user.dir"));
////        c.cd("C:\\users");
////        assertEquals(c.pwd(),"C:\\Users");
////        System.setProperty("user.dir",currneDirectory.getAbsolutePath());
////    }
//    @Test
//    public void testCD1(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String oldDir=System.getProperty("user.dir");
//        String back="..\\";
//        c.cd(back);
//        assertNotEquals(System.getProperty("user.dir"),oldDir);
//    }
//    @Test
//    public void testCD2(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        File currneDirectory = new File(System.getProperty("user.dir"));
//        c.cd("C:\\Users");
//        assertEquals(System.getProperty("user.dir"),"C:\\Users");
//        System.setProperty("user.dir",currneDirectory.getAbsolutePath());
//    }
//    @Test
//    public void testCD3(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String oldDir=System.getProperty("user.dir");
//        String newPath=".\\";//equal current path
//        c.cd(newPath);
//        assertEquals(oldDir, System.getProperty("user.dir"));
//    }
//
//    @Test
//    public void testLs1(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String fileInDir="src";//file exist --->true
//        ArrayList<String>files=c.ls(".\\");
//        assertTrue(files.contains(fileInDir));
//    }
//    @Test
//    public void testLs2(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir=".git";//hidden file ------>false
//        ArrayList<String>files=c.ls(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//    @Test
//    public void testLs3(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir="doesnotexist";//dosen`t exist file ---->false
//        ArrayList<String>files=c.ls(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//    @Test
//    public void testLs4(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir="D:\\Users\\dell\\Desktop\\project"; //Path dosen`t exist ---->false
//        String fileInDir="C.txt";
//        ArrayList<String>files=c.ls(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//
//    @Test
//    public void testLsR1(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir="src";//exist file ----->true
//        ArrayList<String>files=c.ls_r(dir);
//        assertTrue(files.contains(fileInDir));
//    }
//    @Test
//    public void testLsR2(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir=".git";//hidden file--->false
//        ArrayList<String>files=c.ls_r(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//    @Test
//    public void testLsR3(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir="E.txt";//dosen`t exist file ----->false
//        ArrayList<String>files=c.ls_r(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//    @Test
//    public void testLsR4(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\students";//dosen`t exist directory ----->false
//        String fileInDir="E.txt";
//        ArrayList<String>files=c.ls_r(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//
//    @Test
//    public void testLsA1(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir="src";//exist file ----->true
//        ArrayList<String>files=c.ls_r(dir);
//        assertTrue(files.contains(fileInDir));
//    }
//    @Test
//    public void testLsA2(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir="(Hidden) HiddenFolder";//hidden file ----->true
//        ArrayList<String>files=c.ls_a(dir);
//        assertTrue(files.contains(fileInDir));
//    }
//    @Test
//    public void testLsA3(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir=".\\";
//        String fileInDir=".git";//Dosen`t Exist file ----->false
//        ArrayList<String>files=c.ls_a(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//    @Test
//    public void testLsA4(){
//        CommandLineInterpreter c=new CommandLineInterpreter();
//        String dir="D:\\Users\\dell\\Desktop\\project";//Dosen`t Exist directory ----->false
//        String fileInDir=".git";
//        ArrayList<String>files=c.ls_a(dir);
//        assertFalse(files.contains(fileInDir));
//    }
//
//    @Test
//    public void test1_mkdir(){// one directory
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] Directories = new String[] {"test1_mkdir"};
//        cli.mkdir(Directories);
//        File newDir = new File(System.getProperty("user.dir"), Directories[0]);
//        assertTrue(newDir.exists());
//    }
//    @Test
//    public void test2_mkdir(){ //multiple directories
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] Directories = new String[] {"test2_mkdir1", "test2_mkdir2", "test2_mkdir3"};
//        cli.mkdir(Directories);
//        File newDir;
//        for (String dir : Directories) {
//            newDir = new File(System.getProperty("user.dir"), dir);
//            assertTrue(newDir.exists());
//        }
//    }
//    @Test
//    public void test3_mkdir(){// one directory with full path
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] Directories = new String[] {".\\test3_mkdir"};
//        cli.mkdir(Directories);
//        File newDir = new File(System.getProperty("user.dir"), Directories[0]);
//        assertTrue(newDir.exists());
//    }
//    @Test
//    public void test4_mkdir(){ //multiple directories with full path
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] Directories = new String[] {".\\test4_mkdir1", ".\\test4_mkdir2", ".\\test2_mkdir3"};
//        cli.mkdir(Directories);
//        File newDir;
//        for (String dir : Directories) {
//            newDir = new File(System.getProperty("user.dir"), dir);
//            assertTrue(newDir.exists());
//        }
//    }
//
//    @Test
//    public void test1_rmdir(){ // empty directory
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        cli.rmdir(new String[]{"EmptyDirectory"});
//        File dir = new File(System.getProperty("user.dir"), "EmptyDirectory");
//        assertTrue(!dir.exists());
//    }
//    @Test
//    public void test2_rmdir(){ //Direcory has files in it
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        cli.rmdir(new String[]{"NotEmptyDirectory"});
//        File dir = new File(System.getProperty("user.dir"), "NotEmptyDirectory");
//        assertFalse(!dir.exists());
//    }
//
//    @Test
//    public void test1_touch(){System.out.println(System.getProperty("user.dir"));
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] newFiles = new String[] {"file1"};
//        cli.touch(newFiles);
//        File newFile = new File(System.getProperty("user.dir"), newFiles[0]);
//        assertTrue(newFile.exists());
//    }
//
//    @Test
//    public void test2_touch(){ //full path
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] newFiles = new String[] {".\\file1"};
//        cli.touch(newFiles);
//        File newFile = new File(System.getProperty("user.dir"), newFiles[0]);
//        assertTrue(newFile.exists());
//    }
//
//    @Test
//    public void test3_touch(){ //multiple files
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] newFiles = new String[] {"file1", "file2"};
//        cli.touch(newFiles);
//        for(String file : newFiles) {
//            File newFile = new File(System.getProperty("user.dir"), file);
//            assertTrue(newFile.exists());
//        }
//    }
//
//    @Test
//    public void test4_touch(){ //multiple files with full path
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] newFiles = new String[] {".\\file1", ".\\file2"};
//        cli.touch(newFiles);
//        for(String file : newFiles) {
//            File newFile = new File(System.getProperty("user.dir"), file);
//            assertTrue(newFile.exists());
//        }
//    }
//
//    @Test
//    public void test1_rm(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] files = new String[] {"file"};
//        cli.rm(files);
//        File fileToBeRemoved = new File(System.getProperty("user.dir"), files[0]);
//        assertFalse(fileToBeRemoved.exists());
//    }
//    @Test
//    public void test2_rm(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] files = new String[] {"file1","file2"};
//        cli.rm(files);
//        for(String file : files) {
//            File fileToBeRemoved = new File(System.getProperty("user.dir"), file);
//            assertFalse(fileToBeRemoved.exists());
//        }
//    }
//    @Test
//    public void test3_rm(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] files = new String[] {".\\file"};
//        cli.rm(files);
//        File fileToBeRemoved = new File(System.getProperty("user.dir"), files[0]);
//        assertFalse(fileToBeRemoved.exists());
//    }
//
//    @Test
//    public void test4_rm(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] files = new String[] {".\\file1",".\\file2"};
//        cli.rm(files);
//        for(String file : files) {
//            File fileToBeRemoved = new File(System.getProperty("user.dir"), file);
//            assertFalse(fileToBeRemoved.exists());
//        }
//    }
//
//    @Test
//    public void test1_mv(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String [] newFiles = new String[] {}; //120
//        cli.touch(newFiles);
//        cli.mv(newFiles, "ananewfile");
//        File newFile = new File(System.getProperty("user.dir"), "ananewfile"); //ananewfile
//        assertTrue(newFile.exists());
//
//        cli.rm(new String[]{"ananewfile"});
//    }
//
//    @Test
//    public void test_cat(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String fileName = "help.txt";
//        ArrayList <String> content = cli.cat(fileName);
//        ArrayList <String> help = cli.help();
//        assertEquals(help,content);
//    }
//
//    @Test
//    public void test_help(){
//        CommandLineInterpreter cli = new CommandLineInterpreter();
//        String fileName = "help.txt";
//        ArrayList <String> content = cli.cat(fileName);
//        ArrayList <String> help = cli.help();
//        assertEquals(help,content);
//    }
//
//
//
//
//}
//
//


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandLineInterpreterTest {

    @BeforeEach
    public void setUp() {
        File currneDirectory = new File(System.getProperty("user.dir"));
        System.setProperty("user.dir", currneDirectory.getAbsolutePath());
        String fileName="";
        File newFile = new File("");
        CommandLineInterpreter cli = new CommandLineInterpreter();
        File file = new File(System.getProperty("user.dir"), "File120");
        String[] newFiles = new String[] {file.getAbsolutePath()}; // 120
        cli.touch(newFiles);

    }

    @Test
    public void testPWD1() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        assertEquals(System.getProperty("user.dir"), c.pwd());
    }

    @Test
    public void testPWD2() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        assertFalse(c.pwd() == "D:\\java\\cmd");
    }

    // @Test
    // public void testPWD3(){
    // CommandLineInterpreter c=new CommandLineInterpreter();
    // File currneDirectory = new File(System.getProperty("user.dir"));
    // c.cd("C:\\users");
    // assertEquals(c.pwd(),"C:\\Users");
    // System.setProperty("user.dir",currneDirectory.getAbsolutePath());
    // }
    @Test
    public void testCD1() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String oldDir = System.getProperty("user.dir");
        String back = "..\\";
        c.cd(back);
        assertNotEquals(System.getProperty("user.dir"), oldDir);
    }

    @Test
    public void testCD2() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        File currneDirectory = new File(System.getProperty("user.dir"));
        c.cd("C:\\Users");
        assertEquals(System.getProperty("user.dir"), "C:\\Users");
        System.setProperty("user.dir", currneDirectory.getAbsolutePath());
    }

    @Test
    public void testCD3() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String oldDir = System.getProperty("user.dir");
        String newPath = ".\\";// equal current path
        c.cd(newPath);
        assertEquals(oldDir, System.getProperty("user.dir"));
    }

    @Test
    public void testLs1() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String fileInDir = "src";// file exist --->true
        ArrayList<String> files = c.ls(".\\");
        assertTrue(files.contains(fileInDir));
    }

    @Test
    public void testLs2() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = ".git";// hidden file ------>false
        ArrayList<String> files = c.ls(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void testLs3() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = "doesnotexist";// dosen`t exist file ---->false
        ArrayList<String> files = c.ls(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void testLs4() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = "D:\\Users\\dell\\Desktop\\project"; // Path dosen`t exist ---->false
        String fileInDir = "C.txt";
        ArrayList<String> files = c.ls(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void testLsR1() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = "src";// exist file ----->true
        ArrayList<String> files = c.ls_r(dir);
        assertTrue(files.contains(fileInDir));
    }

    @Test
    public void testLsR2() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = ".git";// hidden file--->false
        ArrayList<String> files = c.ls_r(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void testLsR3() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = "E.txt";// dosen`t exist file ----->false
        ArrayList<String> files = c.ls_r(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void testLsR4() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\students";// dosen`t exist directory ----->false
        String fileInDir = "E.txt";
        ArrayList<String> files = c.ls_r(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void testLsA1() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = "src";// exist file ----->true
        ArrayList<String> files = c.ls_r(dir);
        assertTrue(files.contains(fileInDir));
    }

    @Test
    public void testLsA2() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = "(Hidden) hidden";// hidden file ----->true
        ArrayList<String> files = c.ls_a(dir);
        assertTrue(files.contains(fileInDir));
    }

    @Test
    public void testLsA3() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = ".\\";
        String fileInDir = ".git";// Dosen`t Exist file ----->false
        ArrayList<String> files = c.ls_a(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void  LsA4() {
        CommandLineInterpreter c = new CommandLineInterpreter();
        String dir = "D:\\Users\\dell\\Desktop\\project";// Dosen`t Exist directory ----->false
        String fileInDir = ".git";
        ArrayList<String> files = c.ls_a(dir);
        assertFalse(files.contains(fileInDir));
    }

    @Test
    public void test1_mkdir() {// one directory
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] Directories = new String[] { "test1_mkdir" };
        cli.mkdir(Directories);
        File newDir = new File(System.getProperty("user.dir"), Directories[0]);
        assertTrue(newDir.exists());

        cli.rmdir(Directories);

    }

    @Test
    public void test2_mkdir() { // multiple directories
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] Directories = new String[] { "test2_mkdir1", "test2_mkdir2", "test2_mkdir3" };
        cli.mkdir(Directories);
        File newDir;
        for (String dir : Directories) {
            newDir = new File(System.getProperty("user.dir"), dir);
            assertTrue(newDir.exists());
        }

        cli.rmdir(Directories);

    }

    @Test
    public void test3_mkdir() {// one directory with full path
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] Directories = new String[] { ".\\test3_mkdir" };
        cli.mkdir(Directories);
        File newDir = new File(System.getProperty("user.dir"), Directories[0]);
        assertTrue(newDir.exists());

        cli.rmdir(Directories);

    }

    @Test
    public void test4_mkdir() { // multiple directories with full path
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] Directories = new String[] { ".\\test4_mkdir1", ".\\test4_mkdir2", ".\\test2_mkdir3" };
        cli.mkdir(Directories);
        File newDir;
        for (String dir : Directories) {
            newDir = new File(System.getProperty("user.dir"), dir);
            assertTrue(newDir.exists());
        }

        cli.rmdir(Directories);
    }

    @Test
    public void test1_rmdir() { // empty directory
        CommandLineInterpreter cli = new CommandLineInterpreter();
        cli.rmdir(new String[] { "EmptyDirectory" });
        File dir = new File(System.getProperty("user.dir"), "EmptyDirectory");
        assertTrue(!dir.exists());
    }

    @Test
    public void test2_rmdir() { // Direcory has files in it
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String [] parentDir =new String[] {"NotEmptyDirectory"};
        cli.mkdir(parentDir);
        String [] childDir =new String[] {"NotEmptyDirectory\\dir"};
        cli.mkdir(childDir);

        cli.rmdir(parentDir);
        File dir = new File(System.getProperty("user.dir"), parentDir[0]);
        assertFalse(!dir.exists());

        //clean after test
        cli.rmdir(childDir);
        cli.rmdir(parentDir);
    }

    @Test
    public void test1_touch() {
        System.out.println(System.getProperty("user.dir"));
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] newFiles = new String[] { "file1" };
        cli.touch(newFiles);
        File newFile = new File(System.getProperty("user.dir"), newFiles[0]);
        assertTrue(newFile.exists());

        cli.rm(newFiles);

    }

    @Test
    public void test2_touch() { // full path
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] newFiles = new String[] { ".\\file1" };
        cli.touch(newFiles);
        File newFile = new File(System.getProperty("user.dir"), newFiles[0]);
        assertTrue(newFile.exists());

        cli.rm(newFiles);

    }

    @Test
    public void test3_touch() { // multiple files
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] newFiles = new String[] { "file1", "file2" };
        cli.touch(newFiles);
        for (String file : newFiles) {
            File newFile = new File(System.getProperty("user.dir"), file);
            assertTrue(newFile.exists());
        }

        cli.rm(newFiles);

    }

    @Test
    public void test4_touch() { // multiple files with full path
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] newFiles = new String[] { ".\\file1", ".\\file2" };
        cli.touch(newFiles);
        for (String file : newFiles) {
            File newFile = new File(System.getProperty("user.dir"), file);
            assertTrue(newFile.exists());
        }
        cli.rm(newFiles);
    }

    @Test
    public void test1_rm() {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] files = new String[] { "file" };
        cli.rm(files);
        File fileToBeRemoved = new File(System.getProperty("user.dir"), files[0]);
        assertFalse(fileToBeRemoved.exists());
    }

    @Test
    public void test2_rm() {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] files = new String[] { "file1", "file2" };
        cli.rm(files);
        for (String file : files) {
            File fileToBeRemoved = new File(System.getProperty("user.dir"), file);
            assertFalse(fileToBeRemoved.exists());
        }
    }

    @Test
    public void test3_rm() {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] files = new String[] { ".\\file" };
        cli.rm(files);
        File fileToBeRemoved = new File(System.getProperty("user.dir"), files[0]);
        assertFalse(fileToBeRemoved.exists());
    }

    @Test
    public void test4_rm() {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String[] files = new String[] { ".\\file1", ".\\file2" };
        cli.rm(files);
        for (String file : files) {
            File fileToBeRemoved = new File(System.getProperty("user.dir"), file);
            assertFalse(fileToBeRemoved.exists());
        }
    }

    @Test
    public void test1_mv() {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        File file = new File(System.getProperty("user.dir"), "File120");
        String[] newFiles = new String[] {file.getAbsolutePath()}; // 120
        cli.touch(newFiles);

        File newFile = new File(System.getProperty("user.dir"), "ananewfile"); // ananewfile
        cli.mv(newFiles, newFile.getAbsolutePath());
        assertTrue(newFile.exists());


        cli.rm(new String[] { newFile.getAbsolutePath() });
    }

    @Test
    public void test_cat(){
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String fileName = "help.txt";
        ArrayList <String> content = cli.cat(fileName);
        ArrayList <String> help = cli.help();
        assertEquals(help,content);
    }

    // Test piping two commands: ls | cat
    @Test
    public void testPipeLsAndCat() {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String dir = ".\\";

        // Capture the output of the ls command
        String lsOutput = cli.executeCommand("ls");

        String catOutput = cli.executeCommandWithInput("cat", lsOutput);

        assertEquals(lsOutput, catOutput);
    }

    @Test
    public void testAppendLsToFile() throws IOException {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String outputFileName = "testAppendLsOutput.txt";

        cli.touch(new String[] { outputFileName });
        File outputFile = new File(System.getProperty("user.dir"), outputFileName);
        assertTrue(outputFile.exists());
        String lsOutput = cli.executeCommand("ls");


        cli.writeToFile(lsOutput, outputFileName);

        BufferedReader reader = new BufferedReader(new FileReader(outputFile));
        String line = reader.readLine();
        assertNotEquals(lsOutput, line);
        reader.close();

        cli.rm(new String[] { outputFileName });
    }

    // Test appending output of pwd to a file (pwd >> filename.txt)
    @Test
    public void testAppendPwdToFile() throws IOException {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        String outputFileName = "testAppendPwdOutput.txt";

        cli.touch(new String[] { outputFileName });
        File outputFile = new File(System.getProperty("user.dir"), outputFileName);
        assertTrue(outputFile.exists());

        String pwdOutput = cli.pwd();
        cli.writeToFile(pwdOutput, outputFileName);
        BufferedReader reader = new BufferedReader(new FileReader(outputFile));
        String line = reader.readLine();
        assertEquals(pwdOutput, line);
        reader.close();
        cli.rm(new String[] { outputFileName});
    }

}