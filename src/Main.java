import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {

    // usage of . and ..
    Path currentDir = Path.of(".");
    System.out.println(currentDir.getParent());
    System.out.println(currentDir);

    Path currentParent = Paths.get("..");
    System.out.println(currentParent);

    // absolute path
    Path currentDir2 = Paths.get("/Users/dzenan/Desktop/DCI/projects/FilesNIO/src");
    System.out.println(currentDir2.getParent());
    System.out.println(currentDir2);

    // relative path
    Path currentDir3 = Paths.get("DCI/projects/FilesNIO/src");
    System.out.println(currentDir3);
    System.out.println(currentDir3.getParent());

    // relative path with base (absolute path)
    Path currentDir4 = Path.of("/Users/dzenan/Desktop/DCI/projects", "FilesNIO/src");
//    Path currentDir4 = Paths.get("/Users/dzenan/Desktop/DCI/projects", "FilesNIO/src");
    System.out.println(currentDir4);

    // relativize - what relative path we need to add to first path in order to get the second path
    // relativize - finding the difference between paths
    Path basePath = Paths.get("/Users/dzenan/Desktop/DCI/projects");
    Path path = currentDir2; // "/Users/dzenan/Desktop/DCI/projects/FilesNIO/src"
    Path basePathRelativeToPath = basePath.relativize(path); // FilesNIO/src
    System.out.println(basePathRelativeToPath);

    Path path1 = Paths.get(basePath.toString(), basePathRelativeToPath.toString());
    System.out.println(path.equals(path1));

    Path pathRelativeToBasePath = path.relativize(basePath); // ../..
    System.out.println(pathRelativeToBasePath);

    Path base = Path.of("/Users");
    Path dciPath = Path.of("/Users/dzenan/Desktop/DCI");

    Path baseToDciPath = base.relativize(dciPath);
    System.out.println(baseToDciPath);

    Path dciPathToBase = dciPath.relativize(base);
    System.out.println(dciPathToBase);

    // normalize
    Path filesNio = Path.of("/Users/dzenan/Desktop/DCI/projects/Files/src/../../FilesNIO");
    System.out.println(filesNio);
    Path filesNioNormalized = filesNio.normalize(); // /Users/dzenan/Desktop/DCI/projects/FilesNIO
    System.out.println(filesNioNormalized);

    // relativize
    Path somePath = Path.of("/private/var/folders/vm/7yh6n6xs7bgfp16n2lf33nm00000gp/T");
    Path someOtherPath = basePath; // "/Users/dzenan/Desktop/DCI/projects"
    Path someToSomeOther = somePath.relativize(someOtherPath);
    System.out.println(someToSomeOther);

    Path someOtherToSome = someOtherPath.relativize(somePath);
    System.out.println(someOtherToSome);
  }
}