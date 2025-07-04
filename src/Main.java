
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

    private static void styleMinecraftButton(JButton button) {
        button.setBackground(new Color(96, 164, 78));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Consolas", Font.BOLD, 18));
        button.setBorder(BorderFactory.createLineBorder(new Color(53, 112, 53), 3));
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Varun's Portfolio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        JLabel headLine = new JLabel("Hi, I am Varun", SwingConstants.CENTER);
        headLine.setFont(new Font("Consolas", Font.BOLD, 45));
        headLine.setForeground(Color.WHITE);

        ImageIcon rightIcon = new ImageIcon(new ImageIcon("Character_Right.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        ImageIcon leftIcon = new ImageIcon(new ImageIcon("Character_Left.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        JLabel characterLabel = new JLabel(rightIcon);

        JPanel sidebar = new JPanel();
        sidebar.setOpaque(false);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        String[] labels = {"About Me", "Skills", "Projects", "Experience", "Why Me?"};
        JButton[] buttons = new JButton[labels.length];

        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            styleMinecraftButton(buttons[i]);
            buttons[i].setMaximumSize(new Dimension(180, 50));
            buttons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            sidebar.add(Box.createVerticalStrut(10));
            sidebar.add(buttons[i]);
        }

        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(characterLabel, Integer.valueOf(1));
        layeredPane.add(headLine, Integer.valueOf(2));
        layeredPane.add(sidebar, Integer.valueOf(3));

        frame.setIconImage(new ImageIcon("logo.png").getImage());
        frame.setVisible(true);

        // Component Resize Logic
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = frame.getWidth();
                int height = frame.getHeight();

                backgroundLabel.setBounds(0, 0, width, height);
                backgroundLabel.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));

                headLine.setBounds(0, (int) (height * 0.05), width, 50);

                characterLabel.setBounds((int) (width * 0.03), (int) (height * 0.55), 200, 200);

                sidebar.setBounds(width - 200, (int) (height * 0.25), 180, 350);
            }
        });

        // Character Movement
        frame.addKeyListener(new KeyAdapter() {
            int x = 0;

            @Override
            public void keyPressed(KeyEvent e) {
                int step = 10;
                int key = e.getKeyCode();
                int frameWidth = frame.getWidth();

                if (key == KeyEvent.VK_LEFT && x - step >= 0) {
                    x -= step;
                    characterLabel.setIcon(leftIcon);
                }
                if (key == KeyEvent.VK_RIGHT && x + step <= frameWidth - 200) {
                    x += step;
                    characterLabel.setIcon(rightIcon);
                }

                characterLabel.setLocation(x, characterLabel.getY());
            }
        });

        // Button Actions
        buttons[0].addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, """
                👤 Name: Varun Dhyani
                🎓 Education: B.Tech CSE, Lovely Professional University 
                📍 Location: Punjab, India
                ✉️ Contact: varundhyani29@gmail.com
            """, "About Me", JOptionPane.PLAIN_MESSAGE);
        });

        buttons[1].addActionListener(e -> {
            JDialog dialog = new JDialog(frame, "My Skills", true);
            dialog.setSize(500, 300);
            dialog.setLocationRelativeTo(frame);
            dialog.setLayout(new GridLayout(5, 1));
            dialog.getContentPane().setBackground(new Color(36, 54, 37));

            String[] skills = {
                "• MERN Stack Developer (MongoDB, Express, React, Node)",
                "• Proficient in Java (Core + Swing)",
                "• UI from Figma",
                "• Familiar with Git, GitHub, REST APIs",
                "• Communication"
            };

            for (String s : skills) {
                JLabel l = new JLabel(s);
                l.setFont(new Font("Consolas", Font.BOLD, 14));
                l.setForeground(Color.WHITE);
                dialog.add(l);
            }
            dialog.setVisible(true);
        });

        buttons[2].addActionListener(e -> {
            String msg = """
                LOOMIN – Full Stack Social Media Platform (June 2025 – Present)

                • Developed a MERN stack social media app with real-time messaging and interactive features.
                • Built secure JWT-based authentication and follow system.
                • Real-time updates via Socket.io (likes, comments, bookmarks).
                • Responsive UI: Bootstrap, TailwindCSS, Lucide icons.
                • Multer for image uploads. Deployed on Railway.
                • Notification system for post interactions.
                • Optimized MongoDB queries for performance.

                🌐 Deployed at: loomin-production.up.railway.app
            """;
            JOptionPane.showMessageDialog(frame, msg, "Projects", JOptionPane.PLAIN_MESSAGE);
        });

        buttons[3].addActionListener(e -> {
            String msg = """
                💼 Web Development Intern – CodeCraft Innovations (Jan 2025 – Mar 2025)

                • Collaborated with a team to build a responsive e-commerce dashboard using React.js.
                • Created RESTful APIs in Node.js and Express for order tracking and inventory management.
                • Improved website performance by optimizing React components and lazy-loading images.
                • Integrated third-party APIs for real-time shipping updates.
                • Participated in daily stand-ups, code reviews, and Agile sprints.

                🌐 Tech Used: React.js, Node.js, Express, MongoDB, Git
            """;
            JOptionPane.showMessageDialog(frame, msg, "Experience", JOptionPane.PLAIN_MESSAGE);
        });

        buttons[4].addActionListener(e -> {
            JFrame memeFrame = new JFrame("Why You Should Hire Me");
            memeFrame.setSize(600, 500);
            memeFrame.setLayout(null);
            memeFrame.setLocationRelativeTo(frame);

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
    }
}
