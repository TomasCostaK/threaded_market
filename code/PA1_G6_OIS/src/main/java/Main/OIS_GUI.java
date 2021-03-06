/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.HashMap;

/*
 * @author omp
 */
public class OIS_GUI extends javax.swing.JFrame {
    
    private javax.swing.JLabel[] out;
    private javax.swing.JLabel[] ent;
    private javax.swing.JLabel[] corridorHall1;
    private javax.swing.JLabel[] corridorHall2;
    private javax.swing.JLabel[] corridorHall3;
    private javax.swing.JLabel[] corridor1;
    private javax.swing.JLabel[] corridor2;
    private javax.swing.JLabel[] corridor3;
    private HashMap<Integer, Integer[]> customerPosition;
    private javax.swing.JLabel[] paymentHall;
    private javax.swing.JLabel[] paymentPoint;

    public OIS_GUI() {
        initComponents();
        out = new javax.swing.JLabel[] {out1,out2,out3,out4,out5,out6,out7,out8,out9,out10,
                                        out11,out12,out13,out14,out15,out16,out17,out18,out19,out20,
                                        out21,out22,out23,out24,out25,out26,out27,out28,out29,out30,
                                        out31,out32,out33,out34,out35,out36,out37,out38,out39,out40,
                                        out41,out42,out43,out44,out45,out46,out47,out48,out49,out50,
                                        out51,out52,out53,out54,out55,out56,out57,out58,out59,out60,
                                        out61,out62,out63,out64,out65,out66,out67,out68,out69,out70,
                                        out71,out72,out73,out74,out75,out76,out77,out78,out79,out80,
                                        out81,out82,out83,out84,out85,out86,out87,out88,out89,out90,
                                        out91,out92,out93,out94,out95,out96,out97,out98,out99};
        ent = new javax.swing.JLabel[] {ent1, ent2, ent3, ent4, ent5, ent6};
        corridorHall1 = new javax.swing.JLabel[] {corr1,corr2,corr3};
        corridorHall2 = new javax.swing.JLabel[] {corr4,corr5,corr6};
        corridorHall3 = new javax.swing.JLabel[] {corr7,corr8,corr9};
        corridor1 = new javax.swing.JLabel[] {corridor1_1,corridor1_2,corridor1_3, corridor1_4,corridor1_5,corridor1_6, corridor1_7,corridor1_8,corridor1_9, corridor1_10};
        corridor2 = new javax.swing.JLabel[] {corridor1_11,corridor1_12,corridor1_13, corridor1_14,corridor1_15,corridor1_16, corridor1_17,corridor1_18,corridor1_19, corridor1_20};
        corridor3 = new javax.swing.JLabel[] {corridor1_21,corridor1_22,corridor1_23, corridor1_24,corridor1_25,corridor1_26, corridor1_27,corridor1_28,corridor1_29, corridor1_30};
        customerPosition = new HashMap<>();
        paymentHall = new javax.swing.JLabel[] {pay1, pay2};
        paymentPoint = new javax.swing.JLabel[] {pay3};
    }
    

    public void cleanCustomers() {
        for(int i=0; i<99; i++) out[i].setText(""); 
        for(int i=0; i<6; i++) ent[i].setText(""); 
        for(int i=0; i<3; i++) corridorHall1[i].setText(""); 
        for(int i=0; i<3; i++) corridorHall2[i].setText(""); 
        for(int i=0; i<3; i++) corridorHall3[i].setText(""); 
        for(int i=0; i<10; i++) corridor1[i].setText(""); 
        for(int i=0; i<10; i++) corridor2[i].setText(""); 
        for(int i=0; i<10; i++) corridor3[i].setText(""); 
        for(int i=0; i<2; i++) paymentHall[i].setText(""); 
        for(int i=0; i<1; i++) paymentPoint[i].setText(""); 
    }
    
    
    public void moveCustomer(int customerId, Integer[] position){
        if(customerPosition.containsKey(customerId)){
            switch(customerPosition.get(customerId)[0]){
                case 0:
                    out[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 1:
                    ent[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 2:
                    corridorHall1[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 3:
                    corridorHall2[customerPosition.get(customerId)[1]].setText("");    
                    break;
                case 4:
                    corridorHall3[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 5:
                    corridor1[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 6:
                    corridor2[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 7:
                    corridor3[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 8:
                    paymentHall[customerPosition.get(customerId)[1]].setText("");
                    break;
                case 9:
                    paymentPoint[0].setText("");
                    break;
                case 10:
                    paymentPoint[0].setText("");
                    break;
                }

            switch(position[0]){
                case 0:
                    out[position[1]].setText(customerId + "");
                    break;
                case 1:
                    ent[position[1]].setText(customerId+"");
                    break;
                case 2:
                    corridorHall1[position[1]].setText(customerId+"");
                    break;
                case 3:
                    corridorHall2[position[1]].setText(customerId+"");
                    break;
                case 4:
                    corridorHall3[position[1]].setText(customerId+"");
                    break;
                case 5:
                    corridor1[position[1]].setText(customerId+"");
                    break;
                case 6:
                    corridor2[position[1]].setText(customerId+"");
                    break;
                case 7:
                    corridor3[position[1]].setText(customerId+"");
                    break;
                case 8:
                    paymentHall[position[1]].setText(customerId+"");
                    break;
                case 9:
                    paymentPoint[0].setText(customerId+"");
                    break;
                case 10:
                    paymentPoint[0].setText("");
                    break;
            }
        }
        else{
            out[position[1]].setText("  " + customerId);
        }
        customerPosition.put(customerId, position);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        idle21 = new javax.swing.JLabel();
        idle109 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel21 = new javax.swing.JPanel();
        ent1 = new javax.swing.JLabel();
        ent2 = new javax.swing.JLabel();
        ent3 = new javax.swing.JLabel();
        ent4 = new javax.swing.JLabel();
        ent6 = new javax.swing.JLabel();
        ent5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        out1 = new javax.swing.JLabel();
        out2 = new javax.swing.JLabel();
        out3 = new javax.swing.JLabel();
        out4 = new javax.swing.JLabel();
        out5 = new javax.swing.JLabel();
        out6 = new javax.swing.JLabel();
        out7 = new javax.swing.JLabel();
        out8 = new javax.swing.JLabel();
        out9 = new javax.swing.JLabel();
        out20 = new javax.swing.JLabel();
        out38 = new javax.swing.JLabel();
        out39 = new javax.swing.JLabel();
        out37 = new javax.swing.JLabel();
        out36 = new javax.swing.JLabel();
        out35 = new javax.swing.JLabel();
        out49 = new javax.swing.JLabel();
        out61 = new javax.swing.JLabel();
        out34 = new javax.swing.JLabel();
        out48 = new javax.swing.JLabel();
        out19 = new javax.swing.JLabel();
        out18 = new javax.swing.JLabel();
        out17 = new javax.swing.JLabel();
        out16 = new javax.swing.JLabel();
        out15 = new javax.swing.JLabel();
        out14 = new javax.swing.JLabel();
        out30 = new javax.swing.JLabel();
        out29 = new javax.swing.JLabel();
        out28 = new javax.swing.JLabel();
        out27 = new javax.swing.JLabel();
        out26 = new javax.swing.JLabel();
        out25 = new javax.swing.JLabel();
        out13 = new javax.swing.JLabel();
        out40 = new javax.swing.JLabel();
        out47 = new javax.swing.JLabel();
        out24 = new javax.swing.JLabel();
        out22 = new javax.swing.JLabel();
        out62 = new javax.swing.JLabel();
        out52 = new javax.swing.JLabel();
        out51 = new javax.swing.JLabel();
        out12 = new javax.swing.JLabel();
        out11 = new javax.swing.JLabel();
        out23 = new javax.swing.JLabel();
        out21 = new javax.swing.JLabel();
        out33 = new javax.swing.JLabel();
        out63 = new javax.swing.JLabel();
        out32 = new javax.swing.JLabel();
        out31 = new javax.swing.JLabel();
        out41 = new javax.swing.JLabel();
        out43 = new javax.swing.JLabel();
        out53 = new javax.swing.JLabel();
        out46 = new javax.swing.JLabel();
        out45 = new javax.swing.JLabel();
        out44 = new javax.swing.JLabel();
        out42 = new javax.swing.JLabel();
        out64 = new javax.swing.JLabel();
        out54 = new javax.swing.JLabel();
        out56 = new javax.swing.JLabel();
        out57 = new javax.swing.JLabel();
        out55 = new javax.swing.JLabel();
        out65 = new javax.swing.JLabel();
        out66 = new javax.swing.JLabel();
        out72 = new javax.swing.JLabel();
        out73 = new javax.swing.JLabel();
        out74 = new javax.swing.JLabel();
        out75 = new javax.swing.JLabel();
        out76 = new javax.swing.JLabel();
        out71 = new javax.swing.JLabel();
        out67 = new javax.swing.JLabel();
        out77 = new javax.swing.JLabel();
        out58 = new javax.swing.JLabel();
        out59 = new javax.swing.JLabel();
        out50 = new javax.swing.JLabel();
        out78 = new javax.swing.JLabel();
        out68 = new javax.swing.JLabel();
        out69 = new javax.swing.JLabel();
        out79 = new javax.swing.JLabel();
        out70 = new javax.swing.JLabel();
        out80 = new javax.swing.JLabel();
        out81 = new javax.swing.JLabel();
        out90 = new javax.swing.JLabel();
        out89 = new javax.swing.JLabel();
        out88 = new javax.swing.JLabel();
        out87 = new javax.swing.JLabel();
        out86 = new javax.swing.JLabel();
        out85 = new javax.swing.JLabel();
        out84 = new javax.swing.JLabel();
        out83 = new javax.swing.JLabel();
        out97 = new javax.swing.JLabel();
        out99 = new javax.swing.JLabel();
        out96 = new javax.swing.JLabel();
        out98 = new javax.swing.JLabel();
        out95 = new javax.swing.JLabel();
        out82 = new javax.swing.JLabel();
        out91 = new javax.swing.JLabel();
        out92 = new javax.swing.JLabel();
        out93 = new javax.swing.JLabel();
        out94 = new javax.swing.JLabel();
        out60 = new javax.swing.JLabel();
        out10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        corr1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        corr2 = new javax.swing.JLabel();
        corr3 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        corr4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        corr5 = new javax.swing.JLabel();
        corr6 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        corr7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        corr8 = new javax.swing.JLabel();
        corr9 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        corridor1_1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        corridor1_2 = new javax.swing.JLabel();
        corridor1_3 = new javax.swing.JLabel();
        corridor1_4 = new javax.swing.JLabel();
        corridor1_5 = new javax.swing.JLabel();
        corridor1_6 = new javax.swing.JLabel();
        corridor1_7 = new javax.swing.JLabel();
        corridor1_8 = new javax.swing.JLabel();
        corridor1_9 = new javax.swing.JLabel();
        corridor1_10 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        corridor1_11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        corridor1_12 = new javax.swing.JLabel();
        corridor1_13 = new javax.swing.JLabel();
        corridor1_14 = new javax.swing.JLabel();
        corridor1_15 = new javax.swing.JLabel();
        corridor1_16 = new javax.swing.JLabel();
        corridor1_17 = new javax.swing.JLabel();
        corridor1_18 = new javax.swing.JLabel();
        corridor1_19 = new javax.swing.JLabel();
        corridor1_20 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        corridor1_21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        corridor1_22 = new javax.swing.JLabel();
        corridor1_23 = new javax.swing.JLabel();
        corridor1_24 = new javax.swing.JLabel();
        corridor1_25 = new javax.swing.JLabel();
        corridor1_26 = new javax.swing.JLabel();
        corridor1_27 = new javax.swing.JLabel();
        corridor1_28 = new javax.swing.JLabel();
        corridor1_29 = new javax.swing.JLabel();
        corridor1_30 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pay1 = new javax.swing.JLabel();
        pay2 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pay3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        idle21.setBackground(new java.awt.Color(238, 239, 239));
        idle21.setForeground(new java.awt.Color(149, 149, 153));
        idle21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idle21.setOpaque(true);

        idle109.setBackground(new java.awt.Color(238, 239, 239));
        idle109.setForeground(new java.awt.Color(149, 149, 153));
        idle109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idle109.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 248, 250));

        jPanel21.setBackground(new java.awt.Color(244, 248, 249));

        ent1.setBackground(new java.awt.Color(242, 243, 243));
        ent1.setForeground(new java.awt.Color(149, 149, 153));
        ent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ent1.setOpaque(true);

        ent2.setBackground(new java.awt.Color(242, 243, 243));
        ent2.setForeground(new java.awt.Color(149, 149, 153));
        ent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ent2.setOpaque(true);

        ent3.setBackground(new java.awt.Color(242, 243, 243));
        ent3.setForeground(new java.awt.Color(149, 149, 153));
        ent3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ent3.setOpaque(true);

        ent4.setBackground(new java.awt.Color(242, 243, 243));
        ent4.setForeground(new java.awt.Color(149, 149, 153));
        ent4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ent4.setOpaque(true);

        ent6.setBackground(new java.awt.Color(242, 243, 243));
        ent6.setForeground(new java.awt.Color(149, 149, 153));
        ent6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ent6.setOpaque(true);

        ent5.setBackground(new java.awt.Color(242, 243, 243));
        ent5.setForeground(new java.awt.Color(149, 149, 153));
        ent5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ent5.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 24, 16));
        jLabel2.setText("Entrance Hall");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ent3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ent6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ent4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ent2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ent5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ent1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ent2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ent3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ent4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ent5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ent6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(244, 250, 251));

        out1.setBackground(new java.awt.Color(238, 239, 239));
        out1.setForeground(new java.awt.Color(149, 149, 153));
        out1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out1.setOpaque(true);

        out2.setBackground(new java.awt.Color(238, 239, 239));
        out2.setForeground(new java.awt.Color(149, 149, 153));
        out2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out2.setOpaque(true);

        out3.setBackground(new java.awt.Color(238, 239, 239));
        out3.setForeground(new java.awt.Color(149, 149, 153));
        out3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out3.setOpaque(true);

        out4.setBackground(new java.awt.Color(238, 239, 239));
        out4.setForeground(new java.awt.Color(149, 149, 153));
        out4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out4.setOpaque(true);

        out5.setBackground(new java.awt.Color(238, 239, 239));
        out5.setForeground(new java.awt.Color(149, 149, 153));
        out5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out5.setOpaque(true);

        out6.setBackground(new java.awt.Color(238, 239, 239));
        out6.setForeground(new java.awt.Color(149, 149, 153));
        out6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out6.setOpaque(true);

        out7.setBackground(new java.awt.Color(238, 239, 239));
        out7.setForeground(new java.awt.Color(149, 149, 153));
        out7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out7.setOpaque(true);

        out8.setBackground(new java.awt.Color(238, 239, 239));
        out8.setForeground(new java.awt.Color(149, 149, 153));
        out8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out8.setOpaque(true);

        out9.setBackground(new java.awt.Color(238, 239, 239));
        out9.setForeground(new java.awt.Color(149, 149, 153));
        out9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out9.setOpaque(true);

        out20.setBackground(new java.awt.Color(238, 239, 239));
        out20.setForeground(new java.awt.Color(149, 149, 153));
        out20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out20.setOpaque(true);

        out38.setBackground(new java.awt.Color(238, 239, 239));
        out38.setForeground(new java.awt.Color(149, 149, 153));
        out38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out38.setOpaque(true);

        out39.setBackground(new java.awt.Color(238, 239, 239));
        out39.setForeground(new java.awt.Color(149, 149, 153));
        out39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out39.setOpaque(true);

        out37.setBackground(new java.awt.Color(238, 239, 239));
        out37.setForeground(new java.awt.Color(149, 149, 153));
        out37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out37.setOpaque(true);

        out36.setBackground(new java.awt.Color(238, 239, 239));
        out36.setForeground(new java.awt.Color(149, 149, 153));
        out36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out36.setOpaque(true);

        out35.setBackground(new java.awt.Color(238, 239, 239));
        out35.setForeground(new java.awt.Color(149, 149, 153));
        out35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out35.setOpaque(true);

        out49.setBackground(new java.awt.Color(238, 239, 239));
        out49.setForeground(new java.awt.Color(149, 149, 153));
        out49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out49.setOpaque(true);

        out61.setBackground(new java.awt.Color(238, 239, 239));
        out61.setForeground(new java.awt.Color(149, 149, 153));
        out61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out61.setOpaque(true);

        out34.setBackground(new java.awt.Color(238, 239, 239));
        out34.setForeground(new java.awt.Color(149, 149, 153));
        out34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out34.setOpaque(true);

        out48.setBackground(new java.awt.Color(238, 239, 239));
        out48.setForeground(new java.awt.Color(149, 149, 153));
        out48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out48.setOpaque(true);

        out19.setBackground(new java.awt.Color(238, 239, 239));
        out19.setForeground(new java.awt.Color(149, 149, 153));
        out19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out19.setOpaque(true);

        out18.setBackground(new java.awt.Color(238, 239, 239));
        out18.setForeground(new java.awt.Color(149, 149, 153));
        out18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out18.setOpaque(true);

        out17.setBackground(new java.awt.Color(238, 239, 239));
        out17.setForeground(new java.awt.Color(149, 149, 153));
        out17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out17.setOpaque(true);

        out16.setBackground(new java.awt.Color(238, 239, 239));
        out16.setForeground(new java.awt.Color(149, 149, 153));
        out16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out16.setOpaque(true);

        out15.setBackground(new java.awt.Color(238, 239, 239));
        out15.setForeground(new java.awt.Color(149, 149, 153));
        out15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out15.setOpaque(true);

        out14.setBackground(new java.awt.Color(238, 239, 239));
        out14.setForeground(new java.awt.Color(149, 149, 153));
        out14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out14.setOpaque(true);

        out30.setBackground(new java.awt.Color(238, 239, 239));
        out30.setForeground(new java.awt.Color(149, 149, 153));
        out30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out30.setOpaque(true);

        out29.setBackground(new java.awt.Color(238, 239, 239));
        out29.setForeground(new java.awt.Color(149, 149, 153));
        out29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out29.setOpaque(true);

        out28.setBackground(new java.awt.Color(238, 239, 239));
        out28.setForeground(new java.awt.Color(149, 149, 153));
        out28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out28.setOpaque(true);

        out27.setBackground(new java.awt.Color(238, 239, 239));
        out27.setForeground(new java.awt.Color(149, 149, 153));
        out27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out27.setOpaque(true);

        out26.setBackground(new java.awt.Color(238, 239, 239));
        out26.setForeground(new java.awt.Color(149, 149, 153));
        out26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out26.setOpaque(true);

        out25.setBackground(new java.awt.Color(238, 239, 239));
        out25.setForeground(new java.awt.Color(149, 149, 153));
        out25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out25.setOpaque(true);

        out13.setBackground(new java.awt.Color(238, 239, 239));
        out13.setForeground(new java.awt.Color(149, 149, 153));
        out13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out13.setOpaque(true);

        out40.setBackground(new java.awt.Color(238, 239, 239));
        out40.setForeground(new java.awt.Color(149, 149, 153));
        out40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out40.setOpaque(true);

        out47.setBackground(new java.awt.Color(238, 239, 239));
        out47.setForeground(new java.awt.Color(149, 149, 153));
        out47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out47.setOpaque(true);

        out24.setBackground(new java.awt.Color(238, 239, 239));
        out24.setForeground(new java.awt.Color(149, 149, 153));
        out24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out24.setOpaque(true);

        out22.setBackground(new java.awt.Color(238, 239, 239));
        out22.setForeground(new java.awt.Color(149, 149, 153));
        out22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out22.setOpaque(true);

        out62.setBackground(new java.awt.Color(238, 239, 239));
        out62.setForeground(new java.awt.Color(149, 149, 153));
        out62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out62.setOpaque(true);

        out52.setBackground(new java.awt.Color(238, 239, 239));
        out52.setForeground(new java.awt.Color(149, 149, 153));
        out52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out52.setOpaque(true);

        out51.setBackground(new java.awt.Color(238, 239, 239));
        out51.setForeground(new java.awt.Color(149, 149, 153));
        out51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out51.setOpaque(true);

        out12.setBackground(new java.awt.Color(238, 239, 239));
        out12.setForeground(new java.awt.Color(149, 149, 153));
        out12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out12.setOpaque(true);

        out11.setBackground(new java.awt.Color(238, 239, 239));
        out11.setForeground(new java.awt.Color(149, 149, 153));
        out11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out11.setOpaque(true);

        out23.setBackground(new java.awt.Color(238, 239, 239));
        out23.setForeground(new java.awt.Color(149, 149, 153));
        out23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out23.setOpaque(true);

        out21.setBackground(new java.awt.Color(238, 239, 239));
        out21.setForeground(new java.awt.Color(149, 149, 153));
        out21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out21.setOpaque(true);

        out33.setBackground(new java.awt.Color(238, 239, 239));
        out33.setForeground(new java.awt.Color(149, 149, 153));
        out33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out33.setOpaque(true);

        out63.setBackground(new java.awt.Color(238, 239, 239));
        out63.setForeground(new java.awt.Color(149, 149, 153));
        out63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out63.setOpaque(true);

        out32.setBackground(new java.awt.Color(238, 239, 239));
        out32.setForeground(new java.awt.Color(149, 149, 153));
        out32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out32.setOpaque(true);

        out31.setBackground(new java.awt.Color(238, 239, 239));
        out31.setForeground(new java.awt.Color(149, 149, 153));
        out31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out31.setOpaque(true);

        out41.setBackground(new java.awt.Color(238, 239, 239));
        out41.setForeground(new java.awt.Color(149, 149, 153));
        out41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out41.setOpaque(true);

        out43.setBackground(new java.awt.Color(238, 239, 239));
        out43.setForeground(new java.awt.Color(149, 149, 153));
        out43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out43.setOpaque(true);

        out53.setBackground(new java.awt.Color(238, 239, 239));
        out53.setForeground(new java.awt.Color(149, 149, 153));
        out53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out53.setOpaque(true);

        out46.setBackground(new java.awt.Color(238, 239, 239));
        out46.setForeground(new java.awt.Color(149, 149, 153));
        out46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out46.setOpaque(true);

        out45.setBackground(new java.awt.Color(238, 239, 239));
        out45.setForeground(new java.awt.Color(149, 149, 153));
        out45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out45.setOpaque(true);

        out44.setBackground(new java.awt.Color(238, 239, 239));
        out44.setForeground(new java.awt.Color(149, 149, 153));
        out44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out44.setOpaque(true);

        out42.setBackground(new java.awt.Color(238, 239, 239));
        out42.setForeground(new java.awt.Color(149, 149, 153));
        out42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out42.setOpaque(true);

        out64.setBackground(new java.awt.Color(238, 239, 239));
        out64.setForeground(new java.awt.Color(149, 149, 153));
        out64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out64.setOpaque(true);

        out54.setBackground(new java.awt.Color(238, 239, 239));
        out54.setForeground(new java.awt.Color(149, 149, 153));
        out54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out54.setOpaque(true);

        out56.setBackground(new java.awt.Color(238, 239, 239));
        out56.setForeground(new java.awt.Color(149, 149, 153));
        out56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out56.setOpaque(true);

        out57.setBackground(new java.awt.Color(238, 239, 239));
        out57.setForeground(new java.awt.Color(149, 149, 153));
        out57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out57.setOpaque(true);

        out55.setBackground(new java.awt.Color(238, 239, 239));
        out55.setForeground(new java.awt.Color(149, 149, 153));
        out55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out55.setOpaque(true);

        out65.setBackground(new java.awt.Color(238, 239, 239));
        out65.setForeground(new java.awt.Color(149, 149, 153));
        out65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out65.setOpaque(true);

        out66.setBackground(new java.awt.Color(238, 239, 239));
        out66.setForeground(new java.awt.Color(149, 149, 153));
        out66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out66.setOpaque(true);

        out72.setBackground(new java.awt.Color(238, 239, 239));
        out72.setForeground(new java.awt.Color(149, 149, 153));
        out72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out72.setOpaque(true);

        out73.setBackground(new java.awt.Color(238, 239, 239));
        out73.setForeground(new java.awt.Color(149, 149, 153));
        out73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out73.setOpaque(true);

        out74.setBackground(new java.awt.Color(238, 239, 239));
        out74.setForeground(new java.awt.Color(149, 149, 153));
        out74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out74.setOpaque(true);

        out75.setBackground(new java.awt.Color(238, 239, 239));
        out75.setForeground(new java.awt.Color(149, 149, 153));
        out75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out75.setOpaque(true);

        out76.setBackground(new java.awt.Color(238, 239, 239));
        out76.setForeground(new java.awt.Color(149, 149, 153));
        out76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out76.setOpaque(true);

        out71.setBackground(new java.awt.Color(238, 239, 239));
        out71.setForeground(new java.awt.Color(149, 149, 153));
        out71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out71.setOpaque(true);

        out67.setBackground(new java.awt.Color(238, 239, 239));
        out67.setForeground(new java.awt.Color(149, 149, 153));
        out67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out67.setOpaque(true);

        out77.setBackground(new java.awt.Color(238, 239, 239));
        out77.setForeground(new java.awt.Color(149, 149, 153));
        out77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out77.setOpaque(true);

        out58.setBackground(new java.awt.Color(238, 239, 239));
        out58.setForeground(new java.awt.Color(149, 149, 153));
        out58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out58.setOpaque(true);

        out59.setBackground(new java.awt.Color(238, 239, 239));
        out59.setForeground(new java.awt.Color(149, 149, 153));
        out59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out59.setOpaque(true);

        out50.setBackground(new java.awt.Color(238, 239, 239));
        out50.setForeground(new java.awt.Color(149, 149, 153));
        out50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out50.setOpaque(true);

        out78.setBackground(new java.awt.Color(238, 239, 239));
        out78.setForeground(new java.awt.Color(149, 149, 153));
        out78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out78.setOpaque(true);

        out68.setBackground(new java.awt.Color(238, 239, 239));
        out68.setForeground(new java.awt.Color(149, 149, 153));
        out68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out68.setOpaque(true);

        out69.setBackground(new java.awt.Color(238, 239, 239));
        out69.setForeground(new java.awt.Color(149, 149, 153));
        out69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out69.setOpaque(true);

        out79.setBackground(new java.awt.Color(238, 239, 239));
        out79.setForeground(new java.awt.Color(149, 149, 153));
        out79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out79.setOpaque(true);

        out70.setBackground(new java.awt.Color(238, 239, 239));
        out70.setForeground(new java.awt.Color(149, 149, 153));
        out70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out70.setOpaque(true);

        out80.setBackground(new java.awt.Color(238, 239, 239));
        out80.setForeground(new java.awt.Color(149, 149, 153));
        out80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out80.setOpaque(true);

        out81.setBackground(new java.awt.Color(238, 239, 239));
        out81.setForeground(new java.awt.Color(149, 149, 153));
        out81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out81.setOpaque(true);

        out90.setBackground(new java.awt.Color(238, 239, 239));
        out90.setForeground(new java.awt.Color(149, 149, 153));
        out90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out90.setOpaque(true);

        out89.setBackground(new java.awt.Color(238, 239, 239));
        out89.setForeground(new java.awt.Color(149, 149, 153));
        out89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out89.setOpaque(true);

        out88.setBackground(new java.awt.Color(238, 239, 239));
        out88.setForeground(new java.awt.Color(149, 149, 153));
        out88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out88.setOpaque(true);

        out87.setBackground(new java.awt.Color(238, 239, 239));
        out87.setForeground(new java.awt.Color(149, 149, 153));
        out87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out87.setOpaque(true);

        out86.setBackground(new java.awt.Color(238, 239, 239));
        out86.setForeground(new java.awt.Color(149, 149, 153));
        out86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out86.setOpaque(true);

        out85.setBackground(new java.awt.Color(238, 239, 239));
        out85.setForeground(new java.awt.Color(149, 149, 153));
        out85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out85.setOpaque(true);

        out84.setBackground(new java.awt.Color(238, 239, 239));
        out84.setForeground(new java.awt.Color(149, 149, 153));
        out84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out84.setOpaque(true);

        out83.setBackground(new java.awt.Color(238, 239, 239));
        out83.setForeground(new java.awt.Color(149, 149, 153));
        out83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out83.setOpaque(true);

        out97.setBackground(new java.awt.Color(238, 239, 239));
        out97.setForeground(new java.awt.Color(149, 149, 153));
        out97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out97.setOpaque(true);

        out99.setBackground(new java.awt.Color(238, 239, 239));
        out99.setForeground(new java.awt.Color(149, 149, 153));
        out99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out99.setOpaque(true);

        out96.setBackground(new java.awt.Color(238, 239, 239));
        out96.setForeground(new java.awt.Color(149, 149, 153));
        out96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out96.setOpaque(true);

        out98.setBackground(new java.awt.Color(238, 239, 239));
        out98.setForeground(new java.awt.Color(149, 149, 153));
        out98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out98.setOpaque(true);

        out95.setBackground(new java.awt.Color(238, 239, 239));
        out95.setForeground(new java.awt.Color(149, 149, 153));
        out95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out95.setOpaque(true);

        out82.setBackground(new java.awt.Color(238, 239, 239));
        out82.setForeground(new java.awt.Color(149, 149, 153));
        out82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out82.setOpaque(true);

        out91.setBackground(new java.awt.Color(238, 239, 239));
        out91.setForeground(new java.awt.Color(149, 149, 153));
        out91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out91.setOpaque(true);

        out92.setBackground(new java.awt.Color(238, 239, 239));
        out92.setForeground(new java.awt.Color(149, 149, 153));
        out92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out92.setOpaque(true);

        out93.setBackground(new java.awt.Color(238, 239, 239));
        out93.setForeground(new java.awt.Color(149, 149, 153));
        out93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out93.setOpaque(true);

        out94.setBackground(new java.awt.Color(238, 239, 239));
        out94.setForeground(new java.awt.Color(149, 149, 153));
        out94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out94.setOpaque(true);

        out60.setBackground(new java.awt.Color(238, 239, 239));
        out60.setForeground(new java.awt.Color(149, 149, 153));
        out60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out60.setOpaque(true);

        out10.setBackground(new java.awt.Color(238, 239, 239));
        out10.setForeground(new java.awt.Color(149, 149, 153));
        out10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        out10.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 28, 12));
        jLabel1.setText("Outside Hall");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out92, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out94, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out95, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out97, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out98, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out99, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out65, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out66, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out79, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(out81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out86, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out87, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out88, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out90, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(out13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addComponent(out10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(out20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(out9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(out19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(out30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(out36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(out46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(out40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                        .addComponent(out31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(out49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(out48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(out41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(out45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(out44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(out53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                        .addComponent(out67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(out61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(out62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(out63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(out64, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(out66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(out65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(out71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(out69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(out78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(out80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(out90, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out88, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out87, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out86, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(out81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(out99, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out98, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out97, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out96, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out95, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out92, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out94, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(244, 248, 249));

        corr1.setBackground(new java.awt.Color(242, 243, 243));
        corr1.setForeground(new java.awt.Color(149, 149, 153));
        corr1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr1.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 24, 16));
        jLabel3.setText("Corridor Hall 1");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        corr2.setBackground(new java.awt.Color(242, 243, 243));
        corr2.setForeground(new java.awt.Color(149, 149, 153));
        corr2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr2.setOpaque(true);

        corr3.setBackground(new java.awt.Color(242, 243, 243));
        corr3.setForeground(new java.awt.Color(149, 149, 153));
        corr3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr3.setOpaque(true);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corr1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corr2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corr3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(corr1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(244, 248, 249));

        corr4.setBackground(new java.awt.Color(242, 243, 243));
        corr4.setForeground(new java.awt.Color(149, 149, 153));
        corr4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr4.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 24, 16));
        jLabel4.setText("Corridor Hall 2");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        corr5.setBackground(new java.awt.Color(242, 243, 243));
        corr5.setForeground(new java.awt.Color(149, 149, 153));
        corr5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr5.setOpaque(true);

        corr6.setBackground(new java.awt.Color(242, 243, 243));
        corr6.setForeground(new java.awt.Color(149, 149, 153));
        corr6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr6.setOpaque(true);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corr4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corr5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corr6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(244, 248, 249));

        corr7.setBackground(new java.awt.Color(242, 243, 243));
        corr7.setForeground(new java.awt.Color(149, 149, 153));
        corr7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr7.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(24, 24, 16));
        jLabel5.setText("Corridor Hall 3");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        corr8.setBackground(new java.awt.Color(242, 243, 243));
        corr8.setForeground(new java.awt.Color(149, 149, 153));
        corr8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr8.setOpaque(true);

        corr9.setBackground(new java.awt.Color(242, 243, 243));
        corr9.setForeground(new java.awt.Color(149, 149, 153));
        corr9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corr9.setOpaque(true);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corr7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corr8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corr9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corr9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(244, 248, 249));

        corridor1_1.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_1.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_1.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(24, 24, 16));
        jLabel6.setText("Corridor 1");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        corridor1_2.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_2.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_2.setOpaque(true);

        corridor1_3.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_3.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_3.setOpaque(true);

        corridor1_4.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_4.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_4.setOpaque(true);

        corridor1_5.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_5.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_5.setOpaque(true);

        corridor1_6.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_6.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_6.setOpaque(true);

        corridor1_7.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_7.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_7.setOpaque(true);

        corridor1_8.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_8.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_8.setOpaque(true);

        corridor1_9.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_9.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_9.setOpaque(true);

        corridor1_10.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_10.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_10.setOpaque(true);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(corridor1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corridor1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(244, 248, 249));

        corridor1_11.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_11.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_11.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(24, 24, 16));
        jLabel7.setText("Corridor 1");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        corridor1_12.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_12.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_12.setOpaque(true);

        corridor1_13.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_13.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_13.setOpaque(true);

        corridor1_14.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_14.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_14.setOpaque(true);

        corridor1_15.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_15.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_15.setOpaque(true);

        corridor1_16.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_16.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_16.setOpaque(true);

        corridor1_17.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_17.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_17.setOpaque(true);

        corridor1_18.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_18.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_18.setOpaque(true);

        corridor1_19.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_19.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_19.setOpaque(true);

        corridor1_20.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_20.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_20.setOpaque(true);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(corridor1_11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corridor1_11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(244, 248, 249));

        corridor1_21.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_21.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_21.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(24, 24, 16));
        jLabel8.setText("Corridor 1");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        corridor1_22.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_22.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_22.setOpaque(true);

        corridor1_23.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_23.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_23.setOpaque(true);

        corridor1_24.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_24.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_24.setOpaque(true);

        corridor1_25.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_25.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_25.setOpaque(true);

        corridor1_26.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_26.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_26.setOpaque(true);

        corridor1_27.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_27.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_27.setOpaque(true);

        corridor1_28.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_28.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_28.setOpaque(true);

        corridor1_29.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_29.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_29.setOpaque(true);

        corridor1_30.setBackground(new java.awt.Color(242, 243, 243));
        corridor1_30.setForeground(new java.awt.Color(149, 149, 153));
        corridor1_30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        corridor1_30.setOpaque(true);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(corridor1_21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corridor1_30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corridor1_21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corridor1_30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(244, 248, 249));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(24, 24, 16));
        jLabel9.setText("Payment Hall");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pay1.setBackground(new java.awt.Color(242, 243, 243));
        pay1.setForeground(new java.awt.Color(149, 149, 153));
        pay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pay1.setOpaque(true);

        pay2.setBackground(new java.awt.Color(242, 243, 243));
        pay2.setForeground(new java.awt.Color(149, 149, 153));
        pay2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pay2.setOpaque(true);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pay1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(pay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pay2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pay1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );

        jPanel30.setBackground(new java.awt.Color(244, 248, 249));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(24, 24, 16));
        jLabel10.setText("Payment Box");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pay3.setBackground(new java.awt.Color(242, 243, 243));
        pay3.setForeground(new java.awt.Color(149, 149, 153));
        pay3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pay3.setOpaque(true);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(pay3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pay3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );

        jLabel11.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel11.setText("OurMarket - OIS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel corr1;
    private javax.swing.JLabel corr2;
    private javax.swing.JLabel corr3;
    private javax.swing.JLabel corr4;
    private javax.swing.JLabel corr5;
    private javax.swing.JLabel corr6;
    private javax.swing.JLabel corr7;
    private javax.swing.JLabel corr8;
    private javax.swing.JLabel corr9;
    private javax.swing.JLabel corridor1_1;
    private javax.swing.JLabel corridor1_10;
    private javax.swing.JLabel corridor1_11;
    private javax.swing.JLabel corridor1_12;
    private javax.swing.JLabel corridor1_13;
    private javax.swing.JLabel corridor1_14;
    private javax.swing.JLabel corridor1_15;
    private javax.swing.JLabel corridor1_16;
    private javax.swing.JLabel corridor1_17;
    private javax.swing.JLabel corridor1_18;
    private javax.swing.JLabel corridor1_19;
    private javax.swing.JLabel corridor1_2;
    private javax.swing.JLabel corridor1_20;
    private javax.swing.JLabel corridor1_21;
    private javax.swing.JLabel corridor1_22;
    private javax.swing.JLabel corridor1_23;
    private javax.swing.JLabel corridor1_24;
    private javax.swing.JLabel corridor1_25;
    private javax.swing.JLabel corridor1_26;
    private javax.swing.JLabel corridor1_27;
    private javax.swing.JLabel corridor1_28;
    private javax.swing.JLabel corridor1_29;
    private javax.swing.JLabel corridor1_3;
    private javax.swing.JLabel corridor1_30;
    private javax.swing.JLabel corridor1_4;
    private javax.swing.JLabel corridor1_5;
    private javax.swing.JLabel corridor1_6;
    private javax.swing.JLabel corridor1_7;
    private javax.swing.JLabel corridor1_8;
    private javax.swing.JLabel corridor1_9;
    private javax.swing.JLabel ent1;
    private javax.swing.JLabel ent2;
    private javax.swing.JLabel ent3;
    private javax.swing.JLabel ent4;
    private javax.swing.JLabel ent5;
    private javax.swing.JLabel ent6;
    private javax.swing.JLabel idle109;
    private javax.swing.JLabel idle21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JLabel out1;
    private javax.swing.JLabel out10;
    private javax.swing.JLabel out11;
    private javax.swing.JLabel out12;
    private javax.swing.JLabel out13;
    private javax.swing.JLabel out14;
    private javax.swing.JLabel out15;
    private javax.swing.JLabel out16;
    private javax.swing.JLabel out17;
    private javax.swing.JLabel out18;
    private javax.swing.JLabel out19;
    private javax.swing.JLabel out2;
    private javax.swing.JLabel out20;
    private javax.swing.JLabel out21;
    private javax.swing.JLabel out22;
    private javax.swing.JLabel out23;
    private javax.swing.JLabel out24;
    private javax.swing.JLabel out25;
    private javax.swing.JLabel out26;
    private javax.swing.JLabel out27;
    private javax.swing.JLabel out28;
    private javax.swing.JLabel out29;
    private javax.swing.JLabel out3;
    private javax.swing.JLabel out30;
    private javax.swing.JLabel out31;
    private javax.swing.JLabel out32;
    private javax.swing.JLabel out33;
    private javax.swing.JLabel out34;
    private javax.swing.JLabel out35;
    private javax.swing.JLabel out36;
    private javax.swing.JLabel out37;
    private javax.swing.JLabel out38;
    private javax.swing.JLabel out39;
    private javax.swing.JLabel out4;
    private javax.swing.JLabel out40;
    private javax.swing.JLabel out41;
    private javax.swing.JLabel out42;
    private javax.swing.JLabel out43;
    private javax.swing.JLabel out44;
    private javax.swing.JLabel out45;
    private javax.swing.JLabel out46;
    private javax.swing.JLabel out47;
    private javax.swing.JLabel out48;
    private javax.swing.JLabel out49;
    private javax.swing.JLabel out5;
    private javax.swing.JLabel out50;
    private javax.swing.JLabel out51;
    private javax.swing.JLabel out52;
    private javax.swing.JLabel out53;
    private javax.swing.JLabel out54;
    private javax.swing.JLabel out55;
    private javax.swing.JLabel out56;
    private javax.swing.JLabel out57;
    private javax.swing.JLabel out58;
    private javax.swing.JLabel out59;
    private javax.swing.JLabel out6;
    private javax.swing.JLabel out60;
    private javax.swing.JLabel out61;
    private javax.swing.JLabel out62;
    private javax.swing.JLabel out63;
    private javax.swing.JLabel out64;
    private javax.swing.JLabel out65;
    private javax.swing.JLabel out66;
    private javax.swing.JLabel out67;
    private javax.swing.JLabel out68;
    private javax.swing.JLabel out69;
    private javax.swing.JLabel out7;
    private javax.swing.JLabel out70;
    private javax.swing.JLabel out71;
    private javax.swing.JLabel out72;
    private javax.swing.JLabel out73;
    private javax.swing.JLabel out74;
    private javax.swing.JLabel out75;
    private javax.swing.JLabel out76;
    private javax.swing.JLabel out77;
    private javax.swing.JLabel out78;
    private javax.swing.JLabel out79;
    private javax.swing.JLabel out8;
    private javax.swing.JLabel out80;
    private javax.swing.JLabel out81;
    private javax.swing.JLabel out82;
    private javax.swing.JLabel out83;
    private javax.swing.JLabel out84;
    private javax.swing.JLabel out85;
    private javax.swing.JLabel out86;
    private javax.swing.JLabel out87;
    private javax.swing.JLabel out88;
    private javax.swing.JLabel out89;
    private javax.swing.JLabel out9;
    private javax.swing.JLabel out90;
    private javax.swing.JLabel out91;
    private javax.swing.JLabel out92;
    private javax.swing.JLabel out93;
    private javax.swing.JLabel out94;
    private javax.swing.JLabel out95;
    private javax.swing.JLabel out96;
    private javax.swing.JLabel out97;
    private javax.swing.JLabel out98;
    private javax.swing.JLabel out99;
    private javax.swing.JLabel pay1;
    private javax.swing.JLabel pay2;
    private javax.swing.JLabel pay3;
    // End of variables declaration//GEN-END:variables
}
