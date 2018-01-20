package com.example.r2d2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labMessage;
    JLabel labRobot;
    JLabel labWall;
    JLabel labWall2;
    JLabel labWall3;
    JLabel labWall4;
    JLabel labWall5;
    JLabel labWall6;
    JLabel labWall7;
    JLabel labWall8;
    JLabel labWall17;
    JLabel labWall18;
    JLabel labWall19;
    JLabel labWall10;
    JLabel labWall20;
    JLabel labWall21;
    JLabel labWall22;
    JLabel labWall23;
    JLabel labWall24;
    JLabel labWall25;
    JLabel labWall11;
    JLabel labWall12;
    JLabel labWall26;
    JLabel labWall27;
    JLabel labWall28;
    JLabel labWall29;
    JLabel labWall30;
    JLabel labWall31;
    JLabel labWall32;
    JLabel labWall13;
    JLabel labWall34;
    JLabel labWall14;
    JLabel labWall15;
    JLabel labWall35;
    JLabel labWall36;
    JLabel labWall37;
    JLabel labWall38;
    JLabel labWall39;
    JLabel labWall16;
    JLabel labC3PO;
    JLabel labDeathStar;
    JLabel labTiefighter;
    JLabel labTiefighter2;
    JLabel labDeathStar2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    JLabel[] zdi;
    Point vychoziPoziceRobot;
    int body = 0;
    Timer casovac;
    int deathStar1deltaX = 5;
    int getDeathStar1deltay = 5;
    int deathStar2deltaX = 5;
    int tieFighter1deltaY = -3;
    int tieFighter2deltaY = -3;
    ArrayList<JLabel> seznamZdi;
    Random nahodnySmer = new Random();

    public HlavniOkno() {
        initComponents();
    }

    private void thisKeyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        Point poziceRobota = labRobot.getLocation();
        int x = poziceRobota.x;
        int y = poziceRobota.y;
        if (labMessage.isVisible() == true) {
            return;
        }
        if (key == KeyEvent.VK_UP) {
            if (zkontrolujkolize(labRobot, 0, -5) == false) {
                y -= 5;
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (zkontrolujkolize(labRobot, 0, 5) == false) {
                y += 5;
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            labRobot.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/r2d2-vpravo.png")));
            if (zkontrolujkolize(labRobot, 5, 0) == false) {
                x += 5;
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            labRobot.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/r2d2-vlevo.png")));
            if (zkontrolujkolize(labRobot, -5, 0) == false) {
                x -= 5;
            }
        }
        poziceRobota.x = x;
        poziceRobota.y = y;
        labRobot.setLocation(poziceRobota);
        if (kolizeC3PO()) {
            labMessage.setVisible(true);
        }
    }

    private void deathStarPohybujSe(ActionEvent e) {
    pohybDeathStar1();
    pohybDeathStar2();
    pohybTieFighter1();
    pohybTieFighter2();
    if (kolizeNepritel(labDeathStar) || kolizeNepritel(labDeathStar2) || kolizeNepritel(labTiefighter) || kolizeNepritel(labTiefighter2)) {
            labRobot.setLocation(vychoziPoziceRobot);}
    }

    private void pohybDeathStar1() {
        Point poziceDeathStar = labDeathStar.getLocation();
        int x = poziceDeathStar.x;
        int y = poziceDeathStar.y;
        if (zkontrolujkolize(labDeathStar, 5, 0) == true) {
            labDeathStar.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/death_star_left.png")));
            deathStar1deltaX = -deathStar1deltaX;
        }
        if (zkontrolujkolize(labDeathStar, -5, 0) == true) {
            labDeathStar.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/death_star_right.png")));
            deathStar1deltaX = -deathStar1deltaX;
        }
        poziceDeathStar.x = x + deathStar1deltaX;
        poziceDeathStar.y = y;
        labDeathStar.setLocation(poziceDeathStar);
    }

    private void pohybDeathStar2() {
        Point poziceDeathStar = labDeathStar2.getLocation();
        int x = poziceDeathStar.x;
        int y = poziceDeathStar.y;
        if (zkontrolujkolize(labDeathStar2, 5, 0) == true) {
            labDeathStar2.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/death_star_left.png")));
            deathStar2deltaX = -deathStar2deltaX;
        }
        if (zkontrolujkolize(labDeathStar2, -5, 0) == true) {
            labDeathStar2.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/death_star_right.png")));
            deathStar2deltaX = -deathStar2deltaX;
        }
        poziceDeathStar.x = x + deathStar2deltaX;
        poziceDeathStar.y = y;
        labDeathStar2.setLocation(poziceDeathStar);
    }

    private void pohybTieFighter1() {
        Point poziceNepritel = labTiefighter.getLocation();
        int x = poziceNepritel.x;
        int y = poziceNepritel.y;
        if (zkontrolujkolize(labTiefighter, 0, 5) == true) {
            tieFighter1deltaY = -tieFighter1deltaY;
        }
        if (zkontrolujkolize(labTiefighter, 0, -5) == true) {
            tieFighter1deltaY = -tieFighter1deltaY;
        }
        poziceNepritel.x = x;
        poziceNepritel.y = y + tieFighter1deltaY;
        labTiefighter.setLocation(poziceNepritel);
    }

    private void pohybTieFighter2() {
        Point poziceNepritel = labTiefighter2.getLocation();
        int x = poziceNepritel.x;
        int y = poziceNepritel.y;
        if (zkontrolujkolize(labTiefighter2, 0, 5) == true) {;
            tieFighter2deltaY = -tieFighter2deltaY;
        }
        if (zkontrolujkolize(labTiefighter2, 0, -5) == true) {
            tieFighter2deltaY = -tieFighter2deltaY;
        }
        poziceNepritel.x = x;
        poziceNepritel.y = y + tieFighter2deltaY;
        labTiefighter2.setLocation(poziceNepritel);
    }

    private boolean zkontrolujkolize(JLabel postava, int posunX, int posunY) {
        int pocetTrue = 0;
        
        for (JLabel labZed: seznamZdi) {
            if (detekceKolize(postava, labZed, posunX, posunY)) {
            pocetTrue += 1;
            }}
        return pocetTrue > 0;
        }
    
    private boolean kolizeNepritel(JLabel nepritel) {
        return detekceKolize(labRobot, nepritel, 0, 0);
    }

    private boolean kolizeC3PO() {
        return detekceKolize(labRobot, labC3PO, 0, 0);
    }

    private boolean detekceKolize(JLabel label1, JLabel label2, int posunX, int posunY) {
        Point souradniceLevyHrac = label1.getLocation();
        Point souradnicePravyHrac = label2.getLocation();
        int ax = souradniceLevyHrac.x + posunX;
        int ay = souradniceLevyHrac.y + posunY;

        int bx = ax + label1.getWidth() + posunX;
        int by = ay + label1.getHeight() + posunY;

        int cx = souradnicePravyHrac.x;
        int cy = souradnicePravyHrac.y;

        int dx = cx + label2.getWidth();
        int dy = cy + label2.getHeight();

        if (ax <= dx && ay <= dy && cx <= bx && cy <= by) {
            return true;
        } else {
            return false;
        }

    }

    private void thisWindowOpened(WindowEvent e) {
        seznamZdi = new ArrayList<JLabel>();
        seznamZdi.add(labWall);
        seznamZdi.add(labWall2);
        seznamZdi.add(labWall3);
        seznamZdi.add(labWall4);
        seznamZdi.add(labWall5);
        seznamZdi.add(labWall6);
        seznamZdi.add(labWall7);
        seznamZdi.add(labWall8);
        seznamZdi.add(labWall10);
        seznamZdi.add(labWall11);
        seznamZdi.add(labWall12);
        seznamZdi.add(labWall13);
        seznamZdi.add(labWall14);
        seznamZdi.add(labWall15);
        seznamZdi.add(labWall16);
        seznamZdi.add(labWall17);
        seznamZdi.add(labWall18);
        seznamZdi.add(labWall19);
        seznamZdi.add(labWall20);
        seznamZdi.add(labWall21);
        seznamZdi.add(labWall22);
        seznamZdi.add(labWall23);
        seznamZdi.add(labWall24);
        seznamZdi.add(labWall25);
        seznamZdi.add(labWall26);
        seznamZdi.add(labWall27);
        seznamZdi.add(labWall28);
        seznamZdi.add(labWall29);
        seznamZdi.add(labWall30);
        seznamZdi.add(labWall31);
        seznamZdi.add(labWall32);
        seznamZdi.add(labWall34);
        seznamZdi.add(labWall35);
        seznamZdi.add(labWall36);
        seznamZdi.add(labWall37);
        seznamZdi.add(labWall38);
        seznamZdi.add(labWall39);

        vychoziPoziceRobot = labRobot.getLocation();

        casovac = new Timer(50, it -> deathStarPohybujSe(it));
        casovac.start();

    }

    private void thisWindowClosing(WindowEvent e) {
        casovac.stop();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labMessage = new JLabel();
        labRobot = new JLabel();
        labWall = new JLabel();
        labWall2 = new JLabel();
        labWall3 = new JLabel();
        labWall4 = new JLabel();
        labWall5 = new JLabel();
        labWall6 = new JLabel();
        labWall7 = new JLabel();
        labWall8 = new JLabel();
        labWall17 = new JLabel();
        labWall18 = new JLabel();
        labWall19 = new JLabel();
        labWall10 = new JLabel();
        labWall20 = new JLabel();
        labWall21 = new JLabel();
        labWall22 = new JLabel();
        labWall23 = new JLabel();
        labWall24 = new JLabel();
        labWall25 = new JLabel();
        labWall11 = new JLabel();
        labWall12 = new JLabel();
        labWall26 = new JLabel();
        labWall27 = new JLabel();
        labWall28 = new JLabel();
        labWall29 = new JLabel();
        labWall30 = new JLabel();
        labWall31 = new JLabel();
        labWall32 = new JLabel();
        labWall13 = new JLabel();
        labWall34 = new JLabel();
        labWall14 = new JLabel();
        labWall15 = new JLabel();
        labWall35 = new JLabel();
        labWall36 = new JLabel();
        labWall37 = new JLabel();
        labWall38 = new JLabel();
        labWall39 = new JLabel();
        labWall16 = new JLabel();
        labC3PO = new JLabel();
        labDeathStar = new JLabel();
        labTiefighter = new JLabel();
        labTiefighter2 = new JLabel();
        labDeathStar2 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("R2D2");
        setBackground(new Color(51, 51, 51));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                thisKeyPressed(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labMessage ----
        labMessage.setFont(new Font("Star Jedi", Font.BOLD, 113));
        labMessage.setHorizontalAlignment(SwingConstants.CENTER);
        labMessage.setForeground(Color.yellow);
        labMessage.setVisible(false);
        labMessage.setText("W i n !");
        contentPane.add(labMessage);
        labMessage.setBounds(305, 195, 600, 125);

        //---- labRobot ----
        labRobot.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/r2d2-vlevo.png")));
        contentPane.add(labRobot);
        labRobot.setBounds(35, 35, labRobot.getPreferredSize().width, 55);

        //---- labWall ----
        labWall.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_long.jpg")));
        contentPane.add(labWall);
        labWall.setBounds(new Rectangle(new Point(0, 30), labWall.getPreferredSize()));

        //---- labWall2 ----
        labWall2.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall2);
        labWall2.setBounds(new Rectangle(new Point(90, 30), labWall2.getPreferredSize()));

        //---- labWall3 ----
        labWall3.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_long.jpg")));
        contentPane.add(labWall3);
        labWall3.setBounds(new Rectangle(new Point(0, 480), labWall3.getPreferredSize()));

        //---- labWall4 ----
        labWall4.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_long.jpg")));
        contentPane.add(labWall4);
        labWall4.setBounds(600, 480, 600, 30);

        //---- labWall5 ----
        labWall5.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_long.jpg")));
        contentPane.add(labWall5);
        labWall5.setBounds(0, 0, 600, 30);

        //---- labWall6 ----
        labWall6.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_long.jpg")));
        contentPane.add(labWall6);
        labWall6.setBounds(600, 0, 600, 30);

        //---- labWall7 ----
        labWall7.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_long.jpg")));
        contentPane.add(labWall7);
        labWall7.setBounds(1170, 30, 30, 450);

        //---- labWall8 ----
        labWall8.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall8);
        labWall8.setBounds(180, 120, 30, 150);

        //---- labWall17 ----
        labWall17.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_2.jpg")));
        contentPane.add(labWall17);
        labWall17.setBounds(new Rectangle(new Point(270, 180), labWall17.getPreferredSize()));

        //---- labWall18 ----
        labWall18.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_2.jpg")));
        contentPane.add(labWall18);
        labWall18.setBounds(840, 270, 30, 60);

        //---- labWall19 ----
        labWall19.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_2.jpg")));
        contentPane.add(labWall19);
        labWall19.setBounds(new Rectangle(new Point(1110, 360), labWall19.getPreferredSize()));

        //---- labWall10 ----
        labWall10.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall10);
        labWall10.setBounds(270, 30, 30, 150);

        //---- labWall20 ----
        labWall20.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_2.jpg")));
        contentPane.add(labWall20);
        labWall20.setBounds(870, 150, 60, 30);

        //---- labWall21 ----
        labWall21.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_4.jpg")));
        contentPane.add(labWall21);
        labWall21.setBounds(new Rectangle(new Point(480, 360), labWall21.getPreferredSize()));

        //---- labWall22 ----
        labWall22.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_4.jpg")));
        contentPane.add(labWall22);
        labWall22.setBounds(120, 360, 120, 30);

        //---- labWall23 ----
        labWall23.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_4.jpg")));
        contentPane.add(labWall23);
        labWall23.setBounds(new Rectangle(new Point(90, 270), labWall23.getPreferredSize()));

        //---- labWall24 ----
        labWall24.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_3.jpg")));
        contentPane.add(labWall24);
        labWall24.setBounds(new Rectangle(new Point(210, 240), labWall24.getPreferredSize()));

        //---- labWall25 ----
        labWall25.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_5.jpg")));
        contentPane.add(labWall25);
        labWall25.setBounds(new Rectangle(new Point(240, 360), labWall25.getPreferredSize()));

        //---- labWall11 ----
        labWall11.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall11);
        labWall11.setBounds(450, 240, 30, 150);

        //---- labWall12 ----
        labWall12.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall12);
        labWall12.setBounds(360, 210, 30, 150);

        //---- labWall26 ----
        labWall26.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_3.jpg")));
        contentPane.add(labWall26);
        labWall26.setBounds(new Rectangle(new Point(360, 120), labWall26.getPreferredSize()));

        //---- labWall27 ----
        labWall27.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_3.jpg")));
        contentPane.add(labWall27);
        labWall27.setBounds(360, 390, 30, 90);

        //---- labWall28 ----
        labWall28.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_2.jpg")));
        labWall28.setVerticalAlignment(SwingConstants.BOTTOM);
        contentPane.add(labWall28);
        labWall28.setBounds(new Rectangle(new Point(570, 145), labWall28.getPreferredSize()));

        //---- labWall29 ----
        labWall29.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_3.jpg")));
        contentPane.add(labWall29);
        labWall29.setBounds(450, 115, 90, 30);

        //---- labWall30 ----
        labWall30.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_5.jpg")));
        contentPane.add(labWall30);
        labWall30.setBounds(540, 115, 150, 30);

        //---- labWall31 ----
        labWall31.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_2.jpg")));
        labWall31.setVerticalAlignment(SwingConstants.BOTTOM);
        contentPane.add(labWall31);
        labWall31.setBounds(new Rectangle(new Point(570, 300), labWall31.getPreferredSize()));

        //---- labWall32 ----
        labWall32.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_4.jpg")));
        contentPane.add(labWall32);
        labWall32.setBounds(660, 360, 120, 30);

        //---- labWall13 ----
        labWall13.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall13);
        labWall13.setBounds(750, 210, 30, 150);

        //---- labWall34 ----
        labWall34.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_3.jpg")));
        contentPane.add(labWall34);
        labWall34.setBounds(new Rectangle(new Point(750, 120), labWall34.getPreferredSize()));

        //---- labWall14 ----
        labWall14.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall14);
        labWall14.setBounds(840, 30, 30, 150);

        //---- labWall15 ----
        labWall15.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall15);
        labWall15.setBounds(840, 330, 30, 150);

        //---- labWall35 ----
        labWall35.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_2.jpg")));
        contentPane.add(labWall35);
        labWall35.setBounds(930, 120, 30, 60);

        //---- labWall36 ----
        labWall36.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_2.jpg")));
        contentPane.add(labWall36);
        labWall36.setBounds(930, 420, 30, 60);

        //---- labWall37 ----
        labWall37.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_horizontal_5.jpg")));
        contentPane.add(labWall37);
        labWall37.setBounds(960, 120, 150, 30);

        //---- labWall38 ----
        labWall38.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_4.jpg")));
        contentPane.add(labWall38);
        labWall38.setBounds(1080, 150, 30, 120);

        //---- labWall39 ----
        labWall39.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_4.jpg")));
        contentPane.add(labWall39);
        labWall39.setBounds(1020, 360, 30, 120);

        //---- labWall16 ----
        labWall16.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/wall_vertical_5.jpg")));
        contentPane.add(labWall16);
        labWall16.setBounds(930, 270, 30, 150);

        //---- labC3PO ----
        labC3PO.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/c3po.png")));
        contentPane.add(labC3PO);
        labC3PO.setBounds(new Rectangle(new Point(1125, 390), labC3PO.getPreferredSize()));

        //---- labDeathStar ----
        labDeathStar.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/death_star_right.png")));
        contentPane.add(labDeathStar);
        labDeathStar.setBounds(new Rectangle(new Point(740, 40), labDeathStar.getPreferredSize()));

        //---- labTiefighter ----
        labTiefighter.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/tiefighter_down.png")));
        contentPane.add(labTiefighter);
        labTiefighter.setBounds(new Rectangle(new Point(125, 35), labTiefighter.getPreferredSize()));

        //---- labTiefighter2 ----
        labTiefighter2.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/tiefighter_down.png")));
        contentPane.add(labTiefighter2);
        labTiefighter2.setBounds(965, 155, 50, 60);

        //---- labDeathStar2 ----
        labDeathStar2.setIcon(new ImageIcon(getClass().getResource("/com/example/r2d2/img/death_star_left.png")));
        contentPane.add(labDeathStar2);
        labDeathStar2.setBounds(760, 405, 70, 70);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(1200, 535);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
