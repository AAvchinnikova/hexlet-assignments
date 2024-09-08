package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String FilePath1,
                                                       String FilePath2,
                                                       String FilePathResult) {
        CompletableFuture<String> content1 = CompletableFuture.supplyAsync(() -> {
            String content = "";

            try {
                content = Files.readString(getFullPath(FilePath1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
                });

        CompletableFuture<String> content2 = CompletableFuture.supplyAsync(() -> {
           String content = "";

           try {
               content = Files.readString(getFullPath(FilePath2));
           } catch (Exception e) {
               new RuntimeException(e);
           }
           return content;
        });

        return content1.thenCombine(content2, (cont1, cont2) -> {
            String union = cont1 + cont2;
            try {
                Files.writeString(getFullPath(FilePathResult), union, StandardOpenOption.CREATE);
            } catch (Exception e) {
                new RuntimeException(e);
            }
            return "ok!";
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknow!";
        });
    }

    public static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt"
        );
        // END
    }
}

