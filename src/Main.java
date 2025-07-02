
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class Main {

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
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Background image
        ImageIcon backgroundIcon = new ImageIcon("Background.jpg");
        Image scaledBackground = backgroundIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledBackground));
        backgroundLabel.setBounds(0, 0, 500, 500);

        // Character image
        ImageIcon characterIcon = new ImageIcon("Character.png");
        Image scaledCharacter = characterIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel characterLabel = new JLabel(new ImageIcon(scaledCharacter));
        characterLabel.setBounds(15, 240, 200, 200); // Updated width to match image

        // Headline text
        JLabel headLine = new JLabel("Hi, I am Varun", SwingConstants.CENTER);
        headLine.setFont(new Font("Consolas", Font.BOLD, 45));
        headLine.setForeground(Color.WHITE);
        headLine.setBounds(0, 35, 500, 40);

        // Sidebar buttons
        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setOpaque(false);
        sidebar.setBounds(300, 100, 200, 1000);

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

            JLabel skill1 = new JLabel("🌐 MERN Stack Developer (MongoDB, Express, React, Node)");
            skill1.setBounds(20, 20, 500, 25);
            skill1.setFont(font);
            skill1.setForeground(textColor);

            JLabel skill2 = new JLabel("☕ Proficient in Java (Core + Swing)");
            skill2.setBounds(20, 50, 500, 25);
            skill2.setFont(font);
            skill2.setForeground(textColor);

            JLabel skill3 = new JLabel("🎨 UI from Figma");
            skill3.setBounds(20, 80, 500, 25);
            skill3.setFont(font);
            skill3.setForeground(textColor);

            JLabel skill4 = new JLabel("🛠️ Familiar with Git, GitHub, REST APIs");
            skill4.setBounds(20, 110, 500, 25);
            skill4.setFont(font);
            skill4.setForeground(textColor);

            JLabel skill5 = new JLabel("🗣️ Communication");
            skill5.setBounds(20, 140, 500, 25);
            skill5.setFont(font);
            skill5.setForeground(textColor);

            dialog.add(skill1);
            dialog.add(skill2);
            dialog.add(skill3);
            dialog.add(skill4);
            dialog.add(skill5);

            dialog.setVisible(true);
        });

        JButton projects = new JButton("Projects");
        projects.setBounds(0, 120, 150, 50);
        projects.setFocusable(false);
        styleMinecraftButton(projects);
        projects.addActionListener(e -> {
            String projectDetails = """
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
            JOptionPane.showMessageDialog(null, projectDetails, "Projects", JOptionPane.PLAIN_MESSAGE);
        });

        JButton experience = new JButton("Experience");
        experience.setBounds(0, 180, 150, 50);
        experience.setFocusable(false);
        styleMinecraftButton(experience);
        experience.addActionListener(e -> {
            String experienceDetails = """
                💼 Web Development Intern – CodeCraft Innovations (Jan 2025 – Mar 2025)

                • Collaborated with a team to build a responsive e-commerce dashboard using React.js.
                • Created RESTful APIs in Node.js and Express for order tracking and inventory management.
                • Improved website performance by optimizing React components and lazy-loading images.
                • Integrated third-party APIs for real-time shipping updates.
                • Participated in daily stand-ups, code reviews, and Agile sprints.

                🌐 Tech Used: React.js, Node.js, Express, MongoDB, Git
            """;

            JOptionPane.showMessageDialog(null, experienceDetails, "Experience", JOptionPane.PLAIN_MESSAGE);
        });

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

        // Add all components to layered pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(characterLabel, Integer.valueOf(1));
        layeredPane.add(headLine, Integer.valueOf(2));
        layeredPane.add(sidebar, Integer.valueOf(3));

        frame.add(layeredPane);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            int x = characterLabel.getX();

            @Override
            public void keyPressed(KeyEvent e) {
                int step = 10;
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT && x - step >= 0) {
                    x -= step;
                }

                if (key == KeyEvent.VK_RIGHT && x + step <= frame.getWidth() - characterLabel.getWidth()) {
                    x += step;
                }

                characterLabel.setLocation(x, characterLabel.getY());
            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }
}
