import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // از کاربر نام فایل جاوا را بگیرید (بدون پسوند .java)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the Java file (without .java extension): ");
        String fileName = scanner.nextLine();

        // مسیر دایرکتوری src که فایل‌های جاوا داخلش هستند
        String srcPath = System.getProperty("user.dir") + "/src/";

        // فایل جاوا را بررسی کنید که وجود دارد یا خیر
        File javaFile = new File(srcPath + fileName + ".java");
        
        if (javaFile.exists()) {
            System.out.println("File exists. Compiling and running...");

            try {
                // مرحله 1: کامپایل فایل جاوا
                Process compileProcess = new ProcessBuilder("javac", javaFile.getAbsolutePath())
                        .inheritIO() // نمایش خروجی در همان کنسول
                        .start();
                compileProcess.waitFor(); // منتظر بمانید تا کامپایل تمام شود

                // بررسی اینکه آیا کامپایل موفقیت‌آمیز بوده است
                if (compileProcess.exitValue() == 0) {
                    // مرحله 2: اجرای فایل کلاس کامپایل شده
                    String classPath = "src";  // مسیر کلاس‌های کامپایل شده

                    // در صورتی که فایل‌ها داخل پکیج هستند، کلاس باید با نام کامل پکیج اجرا شود
                    // فرض می‌کنیم فایل‌ها بدون پکیج هستند
                    Process runProcess = new ProcessBuilder("java", "-cp", classPath, fileName)
                            .inheritIO()
                            .start();
                    runProcess.waitFor(); // منتظر بمانید تا اجرای برنامه تمام شود

                    // بررسی اینکه آیا اجرای کلاس موفقیت‌آمیز بوده است
                    if (runProcess.exitValue() == 0) {
                        System.out.println("Execution finished successfully.");
                    } else {
                        System.out.println("Error during execution.");
                    }
                } else {
                    System.out.println("Compilation failed.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}
