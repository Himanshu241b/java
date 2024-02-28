//imports
import java.util.Scanner;
import java.util.Stack;

class UnixFilePath{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of file to simplify:");
        String path = scanner.next();
        System.out.println("Simplified path: " + simplifyPath(path));
    }

    /**
     * method to simplify the path of directory and return it
     * @param path // input command
     * @return simplified absolute path
     */
    public static String simplifyPath(String path){
        String[] directories = path.split("/"); // split directory names and add them in a list
        Stack<String> stack = new Stack<String>(); // make a stack to simplify the path

        //add directories to path
        for(String directory : directories){
            if(directory.equals("..")) // going a step upwards in directory  hierarchy
                stack.pop();
            else if(!directory.isEmpty() &&!directory.equals(".")) // push if its a directory
                stack.push(directory);
        }

        // make simplified path by iterating on stack
        StringBuilder simplifiedPath = new StringBuilder("/");
        for(String directory : stack){
            simplifiedPath.append(directory).append("/");
        }

        //check for trailing slash at end string
        if(simplifiedPath.length() > 1){
            simplifiedPath.deleteCharAt(simplifiedPath.length()-1);//remove trailing slash
        }
        return simplifiedPath.toString();
    }

}