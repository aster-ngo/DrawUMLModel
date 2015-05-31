/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drawuml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nam
 */
public class Menu extends javax.swing.JFrame implements ActionListener {
    public Main main;
    public readFile rf;
    public Menu() {
        initComponents();
        setContentPane(scp);
        run.addActionListener(this);
        design.addActionListener(this);
        infomation.addActionListener(this);
        setVisible(true);
        setTitle(" Convet code ");
        setSize(1000, 700);
        setLocation(200, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        print();
    }

    private void print(){
        rf=new readFile();
        for(int i=0;i<rf.arr.size();i++){
            ta.append(rf.arr.get(i).name+"\n");
            for(int j=0;j<rf.arr.get(i).variables.size();j++){
                ta.append(rf.arr.get(i).variables.get(j)+"\n");
                }
            for(int j=0;j<rf.arr.get(i).methods.size();j++)
                ta.append(rf.arr.get(i).methods.get(j)+"\n");
            ta.append("\n");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scp = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        convert = new javax.swing.JMenu();
        run = new javax.swing.JMenuItem();
        info = new javax.swing.JMenu();
        infomation = new javax.swing.JMenuItem();
        design = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ta.setColumns(20);
        ta.setRows(5);
        scp.setViewportView(ta);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        convert.setText("Convert");

        run.setText("Run");
        convert.add(run);

        jMenuBar1.add(convert);

        info.setText("Infomation");

        infomation.setText("Infomation");
        info.add(infomation);

        design.setText("Design");
        info.add(design);

        jMenuBar1.add(info);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scp, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu convert;
    private javax.swing.JMenuItem design;
    private javax.swing.JMenu info;
    private javax.swing.JMenuItem infomation;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem run;
    private javax.swing.JScrollPane scp;
    private javax.swing.JTextArea ta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
       Object o=e.getSource();
        //hiá»ƒn thá»‹ Frame convert
        if(o.equals(run)){
            main.VFrame.setVisible(true);
            setVisible(false);
        }
        // hiá»ƒn thá»‹ frame infomation
        if(o.equals(infomation)){
            JFrame frame=new JFrame("Infomation");
            frame.setSize(400, 100);
            frame.setLocation(400, 100);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            
            JLabel label=new JLabel("ChuÌ‰ Ä‘ÃªÌ€ : XÃ¢y dÆ°Ì£ng biÃªÌ‰u Ä‘Ã´Ì€ lÆ¡Ì�p tÆ°Ì€ maÌ€ nguÃ´Ì€n Java !");
            label.setBounds(85, 25 ,300, 15);
            frame.add(label);
            
        }
        //hiá»ƒn thá»‹ frame design
        if(o.equals(design)){
            JFrame frame=new JFrame("Design");
            frame.setSize(300, 200);
            frame.setLocation(400, 100);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            JLabel label0=new JLabel("â€ _Nhá»¯ng NgÆ°á»�i Thá»±c Hiá»‡n_â€ ");
            label0.setBounds(65, 20, 200,15);
            frame.add(label0);
            JLabel label1=new JLabel("Trá»‹nh XuÃ¢n Nam");
            JLabel label2=new JLabel("NgÃ´ Ä�á»©c DÆ°Æ¡ng");
            JLabel label3=new JLabel("Ä�áº·ng VÄƒn Ä�oÃ n");
            JLabel label4=new JLabel("Ä�á»— Tuáº¥n Anh");
            JLabel label5=new JLabel("@ Designed.2013 @");
            label1.setBounds(100, 50,200 ,15);
            label2.setBounds(100, 70,200 ,15);
            label3.setBounds(100, 90,200 ,15);
            label4.setBounds(100, 110,200 ,15);
            label5.setBounds(90, 150,200 ,15);
            frame.add(label1);
            frame.add(label2);
            frame.add(label3);
            frame.add(label4);
            frame.add(label5);
        } 
    }
}
