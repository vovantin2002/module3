import org.apache.logging.log4j.message.Message;

import java.awt.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.websocket.Session;

// Lớp chứa thông tin email người nhận và mã xác nhận
class EmailInfo {
    public String email;
    public String code;
}

public class RegisterForm extends JFrame {
    private JTextField emailField;
    private JButton registerButton;

    public RegisterForm() {
        initUI();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);

        registerButton = new JButton("Đăng ký");
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin email
                String email = emailField.getText();

                // Tạo mã xác nhận ngẫu nhiên
                String code = String.format("%06d", new Random().nextInt(999999));

                // Lưu thông tin email và mã xác nhận vào đối tượng EmailInfo
                EmailInfo info = new EmailInfo();
                info.email = email;
                info.code = code;

                // Thực hiện gửi email xác nhận
                sendConfirmationEmail(info);

                // Chuyển hướng đến trang xác nhận đăng ký
                ConfirmForm confirmForm = new ConfirmForm(info);
                confirmForm.setVisible(true);
                dispose();
            }
        });

        add(panel, BorderLayout.CENTER);
    }

    private void sendConfirmationEmail(EmailInfo info) {
        // Thiết lập thông tin SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Thiết lập thông tin xác thực tài khoản email người gửi
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your-email@gmail.com", "your-email-password");
            }
        };

        // Tạo đối tượng Session để thiết lập kết nối với SMTP server
        Session session = Session.getInstance(props, auth);

        try {
            // Tạo đối tượng Message để tạo nội dung email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your-email@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(info.email));
            message.setSubject("Xác nhận đăng ký tài khoản");
            message.setText("Mã xác nhận của bạn là: " + info.code);

            // Gửi email
            Transport.send(message);
            System.out.println("Đã gửi email xác nhận đến " + info.email);
        } catch (MessagingException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RegisterForm form = new RegisterForm();
            form.setVisible(true);
        });
    }
}