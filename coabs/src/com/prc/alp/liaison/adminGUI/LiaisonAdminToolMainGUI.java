/* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Copyright (c) 2000-2001 PRC Inc., a wholly-owned
 *   subsidiary of Northrop Grumman Corporation.
 *
 *   This software may be used only in accordance
 *   with the Cougaar Open Source License Agreement. 
 *   See http://www.cougaar.org/documents/license.html
 *   or the www.cougaar.org Web site for more information.
 *   All other rights reserved to PRC Inc.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Authors:  John Page, Brandon L. Buteau
 *
 */

package com.prc.alp.liaison.adminGUI;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.prc.alp.liaison.admin.ALPAgentReference;
import com.prc.alp.liaison.admin.ExternalAgentReference;
import com.prc.alp.liaison.admin.LiaisonStatusReference;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;


/**
 * The class is the frame for the main window of the liaison AdminGui.
 *
 * @author John Page
 * @author Brandon L. Buteau
 * @version 1.1
 * @since 1.0
 */
public class LiaisonAdminToolMainGUI extends javax.swing.JFrame {

    /** Pointer to the application shell for access to public structures.
     */
    public LiaisonAdminToolController theApplication;
    public DefaultListModel defListModel;
    public AlpSocDisplayModelServer alpDisplay;
    public ExtSocDisplayModelServer extDisplay;
    
    /** Creates new form LiaisonAdminToolMainGUI
     * @param app Pointer to the LiaisonAdminToolController (application shell) for access to all public data structures.
     */
    public LiaisonAdminToolMainGUI(LiaisonAdminToolController app) {
        theApplication = app;
        alpDisplay = theApplication.alpDisplayServer;
        extDisplay = theApplication.extDisplayServer;
        initComponents ();
        pack ();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents () {//GEN-BEGIN:initComponents
      mainSplitPane = new javax.swing.JSplitPane ();
      mainAlpScrollPane = new javax.swing.JScrollPane ();
      mainALPTree = new javax.swing.JTree ();
      mainExtScrollPane = new javax.swing.JScrollPane ();
      mainExtTree = new javax.swing.JTree ();
      permissionsPanel = new javax.swing.JPanel ();
      alpSelDescLabel1 = new javax.swing.JLabel ();
      alpSelDescLabel2 = new javax.swing.JLabel ();
      alpSelDescLabel3 = new javax.swing.JLabel ();
      alpSelDescLabel4 = new javax.swing.JLabel ();
      extSelDescLabel2 = new javax.swing.JLabel ();
      extSelDescLabel3 = new javax.swing.JLabel ();
      isEnabledComboBox = new javax.swing.JComboBox ();
      isEnabledComboBox.setModel(new BooleanComboBoxModel(LiaisonAdminToolController.strIS_ENABLED,
      LiaisonAdminToolController.strIS_NOT_ENABLED));
      isEnabledComboBox.setRenderer(new DefaultListCellRenderer());
      isEnabledComboBox.addActionListener(new IsEnabledActionListener(theApplication));
      mayInitComboBox = new javax.swing.JComboBox ();
      mayInitComboBox.setModel(new BooleanComboBoxModel(LiaisonAdminToolController.strMAY_INITIATE,
      LiaisonAdminToolController.strMAY_NOT_INITIATE));
      mayInitComboBox.setRenderer(new DefaultListCellRenderer());
      mayInitComboBox.addActionListener(new MayInitActionListener(theApplication));

      mayRespComboBox = new javax.swing.JComboBox ();
      mayRespComboBox.setModel(new BooleanComboBoxModel(LiaisonAdminToolController.strMAY_RESPOND,
      LiaisonAdminToolController.strMAY_NOT_RESPOND));
      mayRespComboBox.setRenderer(new DefaultListCellRenderer());
      mayRespComboBox.addActionListener(new MayRespActionListener(theApplication));
      delegatesComboBox = new javax.swing.JComboBox ();
      delegatesComboBox.setModel(new BooleanComboBoxModel( LiaisonAdminToolController.strDELEGATES,
      LiaisonAdminToolController.strNOT_DELEGATES));

      delegatesComboBox.setRenderer( new DefaultListCellRenderer());
      delegatesComboBox.addActionListener(new DelegatesActionListener(theApplication));
      contentsLabel = new javax.swing.JLabel ();
      statusBarLabel = new javax.swing.JLabel ();
      mainTopPanel = new javax.swing.JPanel ();
      jLabel3 = new javax.swing.JLabel ();
      jLabel1 = new javax.swing.JLabel ();
      jLabel4 = new javax.swing.JLabel ();
      extSocComboBox = new javax.swing.JComboBox ();
      extSocComboBox.setModel(theApplication.extDisplayServer.getMainExtSocListModel());
      extSocComboBox.setRenderer(new DefaultListCellRenderer());
      extSocComboBox.addActionListener(new ExtSocListActionListener(theApplication));
      alpSocComboBox = new javax.swing.JComboBox ();
      alpSocComboBox.setModel(theApplication.alpDisplayServer.getMainAlpSocListModel());
      alpSocComboBox.setRenderer(new DefaultListCellRenderer());
      alpSocComboBox.addActionListener(new AlpSocListActionListener(theApplication));
      setTitle ("ALP Liaison Administration Tool");
      addWindowListener (new java.awt.event.WindowAdapter () {
        public void windowClosing (java.awt.event.WindowEvent evt) {
          exitForm (evt);
        }
      }
      );

      mainSplitPane.setPreferredSize (new java.awt.Dimension(600, 300));

        mainAlpScrollPane.setPreferredSize (new java.awt.Dimension(280, 300));
  
          mainALPTree.setShowsRootHandles (true);
    
          mainAlpScrollPane.setViewportView (mainALPTree);
    
        mainSplitPane.setLeftComponent (mainAlpScrollPane);
  
        mainExtScrollPane.setPreferredSize (new java.awt.Dimension(280, 300));
  
          mainExtTree.setShowsRootHandles (true);
    
          mainExtScrollPane.setViewportView (mainExtTree);
    
        mainSplitPane.setRightComponent (mainExtScrollPane);
  

      getContentPane ().add (mainSplitPane, java.awt.BorderLayout.CENTER);

      permissionsPanel.setLayout (new java.awt.GridBagLayout ());
      java.awt.GridBagConstraints gridBagConstraints1;
      permissionsPanel.setPreferredSize (new java.awt.Dimension(305, 200));
      permissionsPanel.setMaximumSize (new java.awt.Dimension(2147483647, 200));
      permissionsPanel.setMinimumSize (new java.awt.Dimension(301, 200));

        alpSelDescLabel1.setText ("Alp Tree Selection");
        alpSelDescLabel1.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.EAST;
        permissionsPanel.add (alpSelDescLabel1, gridBagConstraints1);
  
        alpSelDescLabel2.setText ("Alp Tree Selection");
        alpSelDescLabel2.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.EAST;
        permissionsPanel.add (alpSelDescLabel2, gridBagConstraints1);
  
        alpSelDescLabel3.setText ("Alp Tree Selection");
        alpSelDescLabel3.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 2;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.EAST;
        permissionsPanel.add (alpSelDescLabel3, gridBagConstraints1);
  
        alpSelDescLabel4.setText ("Alp Tree Selection");
        alpSelDescLabel4.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.EAST;
        permissionsPanel.add (alpSelDescLabel4, gridBagConstraints1);
  
        extSelDescLabel2.setText ("Ext Tree Selection");
        extSelDescLabel2.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 2;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
        permissionsPanel.add (extSelDescLabel2, gridBagConstraints1);
  
        extSelDescLabel3.setText ("Ext Tree Selection");
        extSelDescLabel3.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
        permissionsPanel.add (extSelDescLabel3, gridBagConstraints1);
  
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints1.weighty = 0.2;
        permissionsPanel.add (isEnabledComboBox, gridBagConstraints1);
  
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.weighty = 0.2;
        permissionsPanel.add (mayInitComboBox, gridBagConstraints1);
  
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 2;
        gridBagConstraints1.weighty = 0.2;
        permissionsPanel.add (mayRespComboBox, gridBagConstraints1);
  
        delegatesComboBox.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            delegatesComboBoxActionPerformed (evt);
          }
        }
        );
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.weighty = 0.2;
        permissionsPanel.add (delegatesComboBox, gridBagConstraints1);
  
        contentsLabel.setText (" its subordinates");
        contentsLabel.setForeground (java.awt.Color.black);
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
        permissionsPanel.add (contentsLabel, gridBagConstraints1);
  
        statusBarLabel.setAlignmentY (0.0F);
        statusBarLabel.setBorder (new javax.swing.border.BevelBorder(0));
        statusBarLabel.setForeground (java.awt.Color.black);
        statusBarLabel.setHorizontalAlignment (javax.swing.SwingConstants.LEFT);
        statusBarLabel.setFont (new java.awt.Font ("Courier New", 0, 12));
  
        gridBagConstraints1 = new java.awt.GridBagConstraints ();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 4;
        gridBagConstraints1.gridwidth = 3;
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.weighty = 0.2;
        permissionsPanel.add (statusBarLabel, gridBagConstraints1);
  

      getContentPane ().add (permissionsPanel, java.awt.BorderLayout.SOUTH);

      mainTopPanel.setLayout (new java.awt.GridBagLayout ());
      java.awt.GridBagConstraints gridBagConstraints2;
      mainTopPanel.setPreferredSize (new java.awt.Dimension(426, 92));

        jLabel3.setText ("ALP Liaison Administration Tool");
        jLabel3.setForeground (java.awt.Color.black);
        jLabel3.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        jLabel3.setFont (new java.awt.Font ("Dialog", 0, 24));
  
        gridBagConstraints2 = new java.awt.GridBagConstraints ();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        gridBagConstraints2.gridwidth = 4;
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints2.weightx = 0.25;
        mainTopPanel.add (jLabel3, gridBagConstraints2);
  
        jLabel1.setText ("ALP Society:");
        jLabel1.setForeground (java.awt.Color.black);
        jLabel1.setFont (new java.awt.Font ("Dialog", 0, 12));
  
        gridBagConstraints2 = new java.awt.GridBagConstraints ();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints2.weightx = 0.15;
        mainTopPanel.add (jLabel1, gridBagConstraints2);
  
        jLabel4.setAlignmentY (0.0F);
        jLabel4.setText ("External Society: ");
        jLabel4.setForeground (java.awt.Color.black);
        jLabel4.setFont (new java.awt.Font ("Dialog", 0, 12));
  
        gridBagConstraints2 = new java.awt.GridBagConstraints ();
        gridBagConstraints2.gridx = 2;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.insets = new java.awt.Insets (0, 0, 0, 2);
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints2.weightx = 0.15;
        mainTopPanel.add (jLabel4, gridBagConstraints2);
  
  
        gridBagConstraints2 = new java.awt.GridBagConstraints ();
        gridBagConstraints2.gridx = 3;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 0.35;
        mainTopPanel.add (extSocComboBox, gridBagConstraints2);
  
  
        gridBagConstraints2 = new java.awt.GridBagConstraints ();
        gridBagConstraints2.gridx = 1;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 0.35;
        mainTopPanel.add (alpSocComboBox, gridBagConstraints2);
  

      getContentPane ().add (mainTopPanel, java.awt.BorderLayout.NORTH);

    }//GEN-END:initComponents

  private void delegatesComboBoxActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delegatesComboBoxActionPerformed
// Add your handling code here:
  }//GEN-LAST:event_delegatesComboBoxActionPerformed

  private void openAlpSocietyMenuItemActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAlpSocietyMenuItemActionPerformed
// Add your handling code here:
  }//GEN-LAST:event_openAlpSocietyMenuItemActionPerformed

  private void editAgentMenuItemActionPeformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAgentMenuItemActionPeformed
// Add your handling code here:
  }//GEN-LAST:event_editAgentMenuItemActionPeformed


    private void exitMenuItemActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit (0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit (0);
    }//GEN-LAST:event_exitForm


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JScrollPane mainAlpScrollPane;
    private javax.swing.JTree mainALPTree;
    private javax.swing.JScrollPane mainExtScrollPane;
    private javax.swing.JTree mainExtTree;
    private javax.swing.JPanel permissionsPanel;
    private javax.swing.JLabel alpSelDescLabel1;
    private javax.swing.JLabel alpSelDescLabel2;
    private javax.swing.JLabel alpSelDescLabel3;
    private javax.swing.JLabel alpSelDescLabel4;
    private javax.swing.JLabel extSelDescLabel2;
    private javax.swing.JLabel extSelDescLabel3;
    private javax.swing.JComboBox isEnabledComboBox;
    private javax.swing.JComboBox mayInitComboBox;
    private javax.swing.JComboBox mayRespComboBox;
    private javax.swing.JComboBox delegatesComboBox;
    private javax.swing.JLabel contentsLabel;
    private javax.swing.JLabel statusBarLabel;
    private javax.swing.JPanel mainTopPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox extSocComboBox;
    private javax.swing.JComboBox alpSocComboBox;
    // End of variables declaration//GEN-END:variables

   /**  this routine assumes a new ALP tree has been brought in by the application, 
        and that the AlpDisplayServer has modeling the necessary things. Now it 
        updates the GUI to reflect all the newly loaded data.  
    */
    public synchronized void loadNewAlpTree() {
 
        DefaultMutableTreeNode  newRoot;
        DefaultTreeModel        newTreeModel;
        SocComboBoxModel        comboModel;
        
        newRoot = alpDisplay.mainWindowTreeTop;
        //System.err.println("Making Tree Model");
        newTreeModel = new DefaultTreeModel(newRoot);
        //System.err.println("Setting Model");
        mainALPTree.setModel(newTreeModel);
        //mainALPTree.setCellRenderer(alpDisplay.trCellRenderer);
        //System.err.println("Setting Renederer");
        mainALPTree.setCellRenderer(alpDisplay.trCellRenderer);
        //System.err.println("Adding Listener...");
        mainALPTree.addTreeSelectionListener(new AlpTreeSelectionListener(theApplication));
        //System.err.println("Setting Selection to first....");
        showAlpTree();  // make sure tree is visible
        mainALPTree.setSelectionRow(0);
        //System.err.println("Leaving Tree Alone...");
        theApplication.currentAlpRef = (ALPAgentReference) theApplication.alpSet.topRef; 
        
        
    }
    
    /** This method is used to update the current external tree to the GUI.  This 
        is the safer method that ensures the Liaison Set is consistent prior 
        to updating.
    */
    public synchronized void validateAndUpdateExternalTree ( ) {
        theApplication.liaisonSet.validate();
        //System.err.println("Done Creating Liaison Set");
         
        // Build the display models using this info. 
        //System.err.println("Generating display models...");
        theApplication.extDisplayServer.loadNewSet(theApplication.extSet);
        
        //statusString = new String("Updating Interface.");
        //theApplication.mainWindow.setStatusBar(statusString);
       
        //System.err.println("Loading new tree.");
        theApplication.mainWindow.loadNewExternalTree(theApplication.currentAlpRef);
    }
    
    /**  This method updates the GUI to reflect a newly loaded external society. 
         It does NOT check for validity first. 
    */
    public synchronized void loadNewExternalTree(ALPAgentReference alpRef) {
        DefaultMutableTreeNode newRoot;
        DefaultTreeModel  newTreeModel;
        SocComboBoxModel  comboModel;
        
        // Need to short circuit if there is nothing to show/select. 
        
        if(theApplication.extSet == null)
            return;
        
        if(theApplication.extSet.size() == 0)
            return;
        
      
         
        newRoot = extDisplay.getTreeRoot(alpRef);
        newTreeModel = new DefaultTreeModel(newRoot);
        mainExtTree.setModel(newTreeModel);
        mainExtTree.setCellRenderer(extDisplay.trCellRenderer);
        theApplication.currentExtRef = (ExternalAgentReference) theApplication.extSet.topRef;
        mainExtTree.addTreeSelectionListener(new ExtTreeSelectionListener(theApplication));
        showExtTree();
        mainExtTree.setSelectionRow(0);
        
        // this will alse need to be changed/deleted. 
       // comboModel = (SocComboBoxModel) extSocComboBox.getModel();     
      //  comboModel.fireChanges = false;
       // comboModel.setFirst();
       // comboModel.fireChanges = true;
    
    }
    
    /** This method sets the enabled property different widgets in the permissions panel 
        based on the boolean parameters supplied. */
    private void  setPermissionsEnabled(boolean isEnabledFlag,  
                                        boolean mayInitFlag,
                                        boolean mayRespFlag,
                                        boolean delegatesFlag){
                                            
        
        // fields covered by isEnabled
        alpSelDescLabel1.setEnabled(isEnabledFlag);
        isEnabledComboBox.setEnabled(isEnabledFlag);
        
        // Fields covered by MayInit
        alpSelDescLabel2.setEnabled(mayInitFlag);
        mayInitComboBox.setEnabled(mayInitFlag);
        extSelDescLabel2.setEnabled(mayInitFlag);
        
        // fields covered by MayResp
        
        alpSelDescLabel3.setEnabled(mayRespFlag);
        mayRespComboBox.setEnabled(mayRespFlag);
        extSelDescLabel3.setEnabled(mayRespFlag);
        
        // fields covered by delegates authority 
        
        alpSelDescLabel4.setEnabled(delegatesFlag);
        delegatesComboBox.setEnabled(delegatesFlag);
        contentsLabel.setEnabled(delegatesFlag);
        
    }
    
    /** Sets the appropriate text values on the labels in the permissions panel based 
        on the current ALPRef and ExtRef selections. 
    */
    private void setPermissionsLabels(ALPAgentReference alpRef, ExternalAgentReference extRef){
        String  alpSelDesc;
        String  alpSelName;
        String  extSelDesc;
        
        
        //  These calls return a blank string when the selection is null
        alpSelDesc = theApplication.getCurrentAlpSelDesc();
        alpSelName = theApplication.getCurrentAlpSelName();
        extSelDesc = theApplication.getCurrentExtSelDesc();
        
          // fields covered by isEnabled
        alpSelDescLabel1.setText(alpSelName);

        
        // Fields covered by MayInit
        alpSelDescLabel2.setText(alpSelDesc);
        extSelDescLabel2.setText(extSelDesc);
        
        // fields covered by MayResp
        
        alpSelDescLabel3.setText(alpSelDesc);
        extSelDescLabel3.setText(extSelDesc);
                
        // fields covered by delegates authority 
        
        alpSelDescLabel4.setText(alpSelName);    
    
    }
    
    /** Sets the values of the combo boxes for the permissions panels, whether or not they may be 
     *  enabled. 
     */
    public synchronized void setPermissionsValues(ALPAgentReference alpRef, ExternalAgentReference extRef){ 
        LiaisonStatusReference  theLSR;
        
        boolean  isEnabled = false;
        boolean  mayInit = false ;
        boolean  mayResp  = false;
        boolean  delegates = false;
        
        // If alp ref is null, they should all be false-- not that it really matters.
        
        
        // if extRef is null, or if a LSR cannot be found, force mayInit, mayResp to false,
        // and get the existing values for the other two from the alp ref.
        
        // otherwise take the necessary info  from both the alp ref and the LSR
        
        if(!(alpRef == null)){
            isEnabled = alpRef.isEnabled.booleanValue();
            delegates = alpRef.delegatesAuthority.booleanValue();
            if( !(extRef == null)){
                theLSR = theApplication.liaisonSet.getStatusRef(alpRef,extRef);
                if(!(theLSR == null)){
                    mayInit = theLSR.ALPCanInitiate.booleanValue();
                    mayResp = theLSR.ALPCanRespond.booleanValue();
                }                
            }
            
        }
        
        
        if(!(theApplication.alpSet == null)){
            if(isEnabled)
                isEnabledComboBox.setSelectedItem(LiaisonAdminToolController.strIS_ENABLED);
            else
                isEnabledComboBox.setSelectedItem(LiaisonAdminToolController.strIS_NOT_ENABLED);
        
            if(delegates)
                delegatesComboBox.setSelectedItem(LiaisonAdminToolController.strDELEGATES);
            else
                delegatesComboBox.setSelectedItem(LiaisonAdminToolController.strNOT_DELEGATES);
        }
        
        // these two calls only make sense when an external tree is loaded. 
        
        if (!(theApplication.extSet == null)) {
            if (!(theApplication.extSet.size() == 0)){
                if(mayInit)
                    mayInitComboBox.setSelectedItem(LiaisonAdminToolController.strMAY_INITIATE);
                else
                    mayInitComboBox.setSelectedItem(LiaisonAdminToolController.strMAY_NOT_INITIATE);
              
                if(mayResp)
                    mayRespComboBox.setSelectedItem(LiaisonAdminToolController.strMAY_RESPOND);
                else
                    mayRespComboBox.setSelectedItem(LiaisonAdminToolController.strMAY_NOT_RESPOND);
            }
        }


        
      
        // This should do it. 
 
        
        
        
    }

    
    /** The high level driver method for having the permissions panel reset to display the proper
        settings, text, and values for the current ALPRef, ExtRef pair 
    */
    
    public synchronized void updatePermissionsPanel(ALPAgentReference alpRef,ExternalAgentReference extRef,
                                       boolean updateValues) {
         boolean  isEnabledFlag = false;
         boolean  mayInitFlag = false;
         boolean  mayRespFlag = false;
         boolean  delegatesFlag = false;
        
        // setting of labels is the same no matter what.  Let's do it.
        
        setPermissionsLabels(alpRef, extRef);
        
        // same with the values, although the following call overwrites silly ones.
        
        if ( updateValues )
            setPermissionsValues(alpRef, extRef);
        
        // Rather than write this as a big cascading if statement, I'll do this 
        // as disjoint if statements that fire a return the short circuits  This, to my
        // eyes, it more readable, and makes the logic easier, since it's based on 
        // progressive elimination. 
        // Note that all flags are initialized as false;
        
        // if the ALP ref is null, everything should be disabled.
        
        if(alpRef == null){
            setPermissionsEnabled(isEnabledFlag, mayInitFlag, mayRespFlag, delegatesFlag);
            return;
        }
        
        //if the ALP ref is not in control, everything should be disabled.
        if(theApplication.alpSet.isAncestorInControl(alpRef)){
            setPermissionsEnabled(isEnabledFlag, mayInitFlag, mayRespFlag, delegatesFlag);
            return;
        }
        
        //  if the Alp Ref is disabled, but in control, only isEnabled should be 
        //  turned on, so that the setting can be changed. 
        if(alpRef.isEnabled.booleanValue() == false){
            isEnabledFlag = true;
            setPermissionsEnabled(isEnabledFlag, mayInitFlag, mayRespFlag, delegatesFlag);
            return;
        }
        
        //if AlpRef is in control and not disabled, but no Ext ref, set the 
        // isEnabled and delegates flags
        if(extRef == null){
            isEnabledFlag = true;
            delegatesFlag = true;
            setPermissionsEnabled(isEnabledFlag, mayInitFlag, mayRespFlag, delegatesFlag);
            return;
        }
        
        //  We know that the AlpRef is in control, not disabled, and there is a valid
        //  ext ref.  Now, if it is an agent, it cannot delegate.
        if(alpRef.isAgent()){
            isEnabledFlag = true;
            mayInitFlag = true;
            mayRespFlag = true;
            setPermissionsEnabled(isEnabledFlag, mayInitFlag, mayRespFlag, delegatesFlag);
            return;
        }        
      
        // finally,  if we've gotten this far all flags are turned on!  
        
        isEnabledFlag = true;
        mayInitFlag = true;
        mayRespFlag = true;
        delegatesFlag = true;       
        setPermissionsEnabled(isEnabledFlag, mayInitFlag, mayRespFlag, delegatesFlag);
                
    }
    
    /** Forces the ALP Tree to repaint itself */
    public synchronized void repaintMainALPTree(){
        // Allows other classes to display the ALP tree without touching any of the 
        // specific GUI elements. 
        int width, height;
        
        width = mainALPTree.getWidth();
        height = mainALPTree.getHeight();
        
        mainALPTree.repaint(0, 0, width, height);
        
        
    }
   
    /** Forces the external tree to repaint itself. */ 
    public synchronized void repaintMainExtTree(){
        // Allows other classes to display the ALP tree without touching any of the 
        // specific GUI elements. 
        int width, height;
        
        width = mainExtTree.getWidth();
        height = mainExtTree.getHeight();
        
        mainExtTree.repaint(0, 0, width, height);
   
        
    }
  
    /** Sets the text in the status bar */
    public void setStatusBar(String newStatus){
        statusBarLabel.setText(newStatus);       
    }
   
    /** Hides the ALP Tree and its window.  Use when no ALP Society loaded. */
    public void  hideAlpTree(){
        mainALPTree.setVisible(false);
    }
    
    /** Makes ALP Tree Visible */
    public void showAlpTree(){
        mainALPTree.setVisible(true);
    }
    
    /** Hides the Ext Tree and its window.  Use when no Ext Tree is loaded. */
    public void hideExtTree(){
        mainExtTree.setVisible(false);
    }
    
    /** Makes external Tree visible */
    public void showExtTree(){
        mainExtTree.setVisible(true);
    }
  
    /** Force a selection of the first ALP Society in the Alp Society Combo Box */
    public void  setFirstAlpTree(){
        SocComboBoxModel theModel;
        theModel = (SocComboBoxModel) alpSocComboBox.getModel();
        theModel.setFirst();      
    }
    
    /** Not implemented yet */
    public void setAlpTreeToCurrentRefs(){
     // Not to worry at the moment....      
        
    }
   
    /** Force a selection of the first External Society in the Ext Society Combo Box */
    public void  setFirstExtTree(){
        SocComboBoxModel theModel;
        theModel = (SocComboBoxModel) extSocComboBox.getModel();
        theModel.setFirst();        
    }
}