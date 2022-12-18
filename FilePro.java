import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class FilePro  {
    public static void main(String[] args) {
        new FilePro();
    }

    public FilePro() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    

    public class TestPane extends JPanel implements ActionListener {
        
        private JTextField txtNewUsername;
        private JTextField txtNewNim;
        private JTextField txtNewHobi;
        private JLabel txtusername;
        private JLabel txtNim;
        private JLabel txtHobi;

        
        private JButton btnCreateAccount;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            txtusername= new JLabel("Nama");
            txtusername.setHorizontalAlignment(SwingConstants.CENTER);
            txtNim= new JLabel("Nim:");
            txtNim.setHorizontalAlignment(SwingConstants.CENTER);
            txtHobi= new JLabel("Hobi :");
            txtHobi.setHorizontalAlignment(SwingConstants.CENTER);

            txtNewUsername = new JTextField(10);
            txtNewNim = new JTextField(10);
            txtNewHobi = new JTextField(10);
            

            btnCreateAccount = new JButton("Input Data");
            add(txtusername);
            add(txtNewUsername, gbc);
            add(txtNim);
            add(txtNewNim, gbc);
            add(txtHobi);
            add(txtNewHobi, gbc);
            add(btnCreateAccount, gbc);

            btnCreateAccount.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            File user = new File("File.txt");
            File Nim = new File("File.txt");
            File Hobi = new File("File.txt");

            if (e.getSource() == btnCreateAccount) {
                try (BufferedWriter addUser = new BufferedWriter(new FileWriter(user, true)); BufferedWriter addNim = new BufferedWriter(new FileWriter(Nim, true)); BufferedWriter addHobi = new BufferedWriter(new FileWriter(Hobi,true))) {
                    addHobi.write("nama :"+txtNewUsername.getText());
                    addHobi.newLine();
                    addNim.write("Nim :"+txtNewNim.getText());
                    addNim.newLine();
                    addUser.write("Hobi :"+txtNewHobi.getText());
                    addUser.newLine();
                    JOptionPane.showMessageDialog(null, "Berhasil di input ke file", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException exp) {
                    JOptionPane.showMessageDialog(this, "Gagal membuat akun", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        }

    }
}