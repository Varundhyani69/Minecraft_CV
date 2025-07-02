
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

class Main {

    private static void styleMinecraftButton(JButton button) {
        button.setBackground(new Color(96, 164, 78));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Consolas", Font.BOLD, 18));
        button.setBorder(new LineBorder(new Color(53, 112, 53), 3));
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Background
        ImageIcon backgroundIcon = new ImageIcon("Background.jpg");
        Image scaledBackground = backgroundIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledBackground));
        backgroundLabel.setBounds(0, 0, 500, 500);

        // Character
        BufferedImage characterImage = null;
        try {
            characterImage = ImageIO.read(new File("Character.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon characterIcon = new ImageIcon(characterImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        JLabel characterLabel = new JLabel(characterIcon);
        characterLabel.setBounds(15, 240, 200, 200);

        // Headline
        JLabel headLine = new JLabel("Hi, I am Varun", SwingConstants.CENTER);
        headLine.setFont(new Font("Consolas", Font.BOLD, 45));
        headLine.setForeground(Color.WHITE);
        headLine.setBounds(0, 35, 500, 40);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setOpaque(false);
        sidebar.setBounds(300, 100, 200, 1000);

        // About Me
        JButton aboutMe = new JButton("About Me");
        aboutMe.setBounds(0, 0, 150, 50);
        aboutMe.setFocusable(false);
        styleMinecraftButton(aboutMe);
        aboutMe.addActionListener(e -> {
            String message = """
                    👤 Name: Varun Dhyani
                    🎓 Education: B.Tech CSE, Lovely Professional University 
                    📍 Location: Punjab, India
                    ✉️ Contact: varundhyani29@gmail.com
                """;
            JOptionPane.showMessageDialog(null, message, "About Me", JOptionPane.PLAIN_MESSAGE);
        });

        // Skills
        JButton skills = new JButton("Skills");
        skills.setBounds(0, 60, 150, 50);
        skills.setFocusable(false);
        styleMinecraftButton(skills);
        skills.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle("My Skills");
            dialog.setSize(500, 300);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(null);
            dialog.getContentPane().setBackground(new Color(36, 54, 37));
            Font font = new Font("Consolas", Font.BOLD, 14);
            Color textColor = Color.WHITE;

            String[] skillTexts = {
                "• MERN Stack Developer (MongoDB, Express, React, Node)",
                "• Proficient in Java (Core + Swing)",
                "• UI from Figma",
                "• Familiar with Git, GitHub, REST APIs",
                "• Communication"
            };

            for (int i = 0; i < skillTexts.length; i++) {
                JLabel skill = new JLabel(skillTexts[i]);
                skill.setBounds(20, 20 + i * 30, 500, 25);
                skill.setFont(font);
                skill.setForeground(textColor);
                dialog.add(skill);
            }

            dialog.setVisible(true);
        });

        // Projects
        JButton projects = new JButton("Projects");
        projects.setBounds(0, 120, 150, 50);
        projects.setFocusable(false);
        styleMinecraftButton(projects);
        projects.addActionListener(e -> {
            String projectDetails = """
                    LOOMIN – Full Stack Social Media Platform (June 2025 – Present)

                    • Developed MERN stack app with real-time messaging.
                    • JWT-based auth, Socket.io updates, MongoDB optimizations.
                    • TailwindCSS, Lucide icons, Multer for uploads.

                    🌐 loomin-production.up.railway.app
                """;
            JOptionPane.showMessageDialog(null, projectDetails, "Projects", JOptionPane.PLAIN_MESSAGE);
        });

        // Experience
        JButton experience = new JButton("Experience");
        experience.setBounds(0, 180, 150, 50);
        experience.setFocusable(false);
        styleMinecraftButton(experience);
        experience.addActionListener(e -> {
            String experienceDetails = """
                    💼 Web Development Intern – CodeCraft (Jan–Mar 2025)

                    • React.js e-commerce dashboard.
                    • Node.js + Express APIs for inventory.
                    • Agile + Git + MongoDB
                """;
            JOptionPane.showMessageDialog(null, experienceDetails, "Experience", JOptionPane.PLAIN_MESSAGE);
        });

        // Why Me
        JButton whyMe = new JButton("Why Me?");
        whyMe.setBounds(0, 240, 150, 50);
        whyMe.setFocusable(false);
        styleMinecraftButton(whyMe);
        whyMe.addActionListener(e -> {
            JFrame memeFrame = new JFrame("Why You Should Hire Me");
            memeFrame.setSize(600, 500);
            memeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            memeFrame.setLayout(null);
            memeFrame.setLocationRelativeTo(null);

            JLabel heading = new JLabel("Why You Should Hire Me", SwingConstants.CENTER);
            heading.setFont(new Font("Consolas", Font.BOLD, 35));
            heading.setBounds(0, 20, 600, 40);
            memeFrame.add(heading);

            ImageIcon memeIcon = new ImageIcon("poor.png");
            Image scaledImage = memeIcon.getImage().getScaledInstance(650, 350, Image.SCALE_SMOOTH);
            JLabel memeLabel = new JLabel(new ImageIcon(scaledImage));
            memeLabel.setBounds(0, 80, 600, 350);
            memeFrame.add(memeLabel);

            memeFrame.setVisible(true);
        });

        sidebar.add(aboutMe);
        sidebar.add(skills);
        sidebar.add(projects);
        sidebar.add(experience);
        sidebar.add(whyMe);

        // Add everything to layeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(characterLabel, Integer.valueOf(1));
        layeredPane.add(headLine, Integer.valueOf(2));
        layeredPane.add(sidebar, Integer.valueOf(3));
        frame.add(layeredPane);

        // Add KeyListener
        BufferedImage finalCharacterImage = characterImage;
        frame.addKeyListener(new KeyAdapter() {
            int x = characterLabel.getX();

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                int step = 10;

                if (key == KeyEvent.VK_LEFT && x - step >= 0) {
                    x -= step;
                    // Use original image (left-facing)
                    ImageIcon icon = new ImageIcon(finalCharacterImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    characterLabel.setIcon(icon);
                }

                if (key == KeyEvent.VK_RIGHT && x + step < frame.getWidth() - 220) {
                    x += step;
                    // Flip image for right-facing
                    BufferedImage flipped = new BufferedImage(finalCharacterImage.getWidth(), finalCharacterImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g = flipped.createGraphics();
                    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                    tx.translate(-finalCharacterImage.getWidth(), 0);
                    g.drawImage(finalCharacterImage, tx, null);
                    g.dispose();

                    ImageIcon flippedIcon = new ImageIcon(flipped.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    characterLabel.setIcon(flippedIcon);
                }

                characterLabel.setLocation(x, characterLabel.getY());
            }

        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();

        frame.setVisible(true);
    }
}
