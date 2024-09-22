import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    public static void main(String[] args) {
        // ایجاد یک فریم
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // ایجاد یک پنل
        JPanel panel = new JPanel();

        // ایجاد یک تکست‌باکس
        JTextField textField = new JTextField(15);

        // ایجاد یک دکمه
        JButton button = new JButton("Click Me");

        // افزودن اکشن به دکمه
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // نمایش پیام با محتوای تکست‌باکس
                JOptionPane.showMessageDialog(null, "Text: " + textField.getText());
            }
        });

        // افزودن اجزا به پنل
        panel.add(textField);
        panel.add(button);

        // افزودن پنل به فریم
        frame.add(panel);

        // نمایش فریم
        frame.setVisible(true);
    }
}
