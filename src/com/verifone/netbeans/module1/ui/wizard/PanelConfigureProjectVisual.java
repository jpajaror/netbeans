/*
 * NewVFIJ2SEProjectVisualPanel1.java
 * Created by: JoswillP1
 *
 * COPYRIGHT (c) 2017 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.netbeans.module1.ui.wizard;

import com.verifone.netbeans.module1.component.ComponentDefinition;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.xml.xpath.XPathExpressionException;
import org.netbeans.spi.project.ui.support.ProjectChooser;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.xml.sax.SAXException;

public final class PanelConfigureProjectVisual extends SettingsPanel
		implements DocumentListener {

	public static final String PROP_COMPONENT_LOCATION = "componentLocation";	//NOI18N
	public static final String PROP_PROJECT_NAME = "projectName";			//NOI18N
	public static final String PROP_PROJECT_LOCATION = "projectLocation";	//NOI18N

	private PanelConfigureProject panel;
	private ComponentDefinition panelCompDef;

	/**
	 * Creates new form NewVFIJ2SEProjectVisualPanel1
	 */
	public PanelConfigureProjectVisual(PanelConfigureProject panel) {
		this.panel = panel;
		initComponents();
		setName(NbBundle.getMessage(PanelConfigureProjectVisual.class,
				"title.NAME_AND_LOCATION"));
		componentFolder.getDocument().addDocumentListener(this);
		projectNameTextField.getDocument().addDocumentListener(this);
		projectLocationTextField.getDocument().addDocumentListener(this);
	}

	@Override
	public String getName() {
		return "Step #1";
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        projectLocationLabel = new javax.swing.JLabel();
        projectLocationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        createdFolderLabel = new javax.swing.JLabel();
        createdFolderTextField = new javax.swing.JTextField();
        componentFolderLabel = new javax.swing.JLabel();
        componentFolder = new javax.swing.JTextField();
        browseComponentButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(projectNameLabel, org.openide.util.NbBundle.getMessage(PanelConfigureProjectVisual.class, "PanelConfigureProjectVisual.projectNameLabel.text")); // NOI18N

        projectNameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.openide.awt.Mnemonics.setLocalizedText(projectLocationLabel, org.openide.util.NbBundle.getMessage(PanelConfigureProjectVisual.class, "PanelConfigureProjectVisual.projectLocationLabel.text")); // NOI18N

        projectLocationTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(PanelConfigureProjectVisual.class, "PanelConfigureProjectVisual.browseButton.text")); // NOI18N
        browseButton.setActionCommand("BROWSE"); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(createdFolderLabel, org.openide.util.NbBundle.getMessage(PanelConfigureProjectVisual.class, "PanelConfigureProjectVisual.createdFolderLabel.text")); // NOI18N

        createdFolderTextField.setEditable(false);

        org.openide.awt.Mnemonics.setLocalizedText(componentFolderLabel, org.openide.util.NbBundle.getMessage(PanelConfigureProjectVisual.class, "PanelConfigureProjectVisual.componentFolderLabel.text")); // NOI18N

        componentFolder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.openide.awt.Mnemonics.setLocalizedText(browseComponentButton, org.openide.util.NbBundle.getMessage(PanelConfigureProjectVisual.class, "PanelConfigureProjectVisual.browseComponentButton.text")); // NOI18N
        browseComponentButton.setActionCommand("BROWSE"); // NOI18N
        browseComponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseComponentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectNameLabel)
                    .addComponent(projectLocationLabel)
                    .addComponent(createdFolderLabel)
                    .addComponent(componentFolderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(componentFolder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createdFolderTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectLocationTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseButton)
                    .addComponent(browseComponentButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(componentFolderLabel)
                    .addComponent(componentFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseComponentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectNameLabel)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdFolderLabel)
                    .addComponent(browseButton)
                    .addComponent(projectLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectLocationLabel)
                    .addComponent(createdFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
		String command = evt.getActionCommand();
		if ("BROWSE".equals(command)) {
			JFileChooser chooser = new JFileChooser();
			FileUtil.preventFileChooserSymlinkTraversal(chooser, null);
			chooser.setDialogTitle(NbBundle.getMessage(
					PanelConfigureProjectVisual.class, "title.SelProjLoc"));
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			String path = this.projectLocationTextField.getText();
			if (path.length() > 0) {
				File f = new File(path);
				if (f.exists()) {
					chooser.setSelectedFile(f);
				}
			}
			if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
				File projectDir = chooser.getSelectedFile();
				projectLocationTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
			}
			panel.fireChangeEvent();
		}
    }//GEN-LAST:event_browseButtonActionPerformed

    private void browseComponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseComponentButtonActionPerformed
        String command = evt.getActionCommand();
        if ("BROWSE".equals(command)) {
            JFileChooser chooser = new JFileChooser();
            FileUtil.preventFileChooserSymlinkTraversal(chooser, null);
            chooser.setDialogTitle(NbBundle.getMessage(
                PanelConfigureProjectVisual.class, "title.SelCompLoc"));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String path = this.componentFolder.getText();
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                chooser.setSelectedFile(f);
            }
        }
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            File projectDir = chooser.getSelectedFile();
            componentFolder.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
        }
        panel.fireChangeEvent();
        }
    }//GEN-LAST:event_browseComponentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton browseComponentButton;
    private javax.swing.JTextField componentFolder;
    private javax.swing.JLabel componentFolderLabel;
    private javax.swing.JLabel createdFolderLabel;
    private javax.swing.JTextField createdFolderTextField;
    private javax.swing.JLabel projectLocationLabel;
    private javax.swing.JTextField projectLocationTextField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    // End of variables declaration//GEN-END:variables

	@Override
	void store(WizardDescriptor settings) {
		String name = projectNameTextField.getText().trim();
		String folder = projectLocationTextField.getText().trim();
		String compFolder = componentFolder.getText().trim();

		settings.putProperty("projdir", new File(folder));		//NOI18N
		settings.putProperty("name", name);						//NOI18N
		try {
			ComponentDefinition compDef = new ComponentDefinition(compFolder);
			if (compDef.validateComponentDef()) {
				panelCompDef = compDef;
				settings.putProperty("compdir", panelCompDef);			//NOI18N
			}
		} catch (IOException ex) { }
	}

	@Override
	void read(WizardDescriptor settings) {
		File projectLocation = (File) settings.getProperty("projdir");
		if (projectLocation == null || projectLocation.getParentFile() == null 
				|| !projectLocation.getParentFile().isDirectory()) {
			projectLocation = ProjectChooser.getProjectsFolder();
		} else {
			projectLocation = projectLocation.getParentFile();
		}
		this.projectLocationTextField.setText(projectLocation.getAbsolutePath());

		String projectName = (String) settings.getProperty ("name"); //NOI18N
		if (projectName == null) {
			projectName = "isdApps.";
		}
		this.projectNameTextField.setText (projectName);
		this.projectNameTextField.selectAll();

		panelCompDef = (ComponentDefinition) settings.getProperty("compdir");
		String strCompLoc;
		if (panelCompDef != null) {
			strCompLoc = panelCompDef.getDirectoryString();
		} else {
			strCompLoc = "C:\\gitrepos\\petroApps\\isdApps\\vsmsV2\\sys\\util";
//			strCompLoc = "/Users/joswill/git/compTest";
		}
		this.componentFolder.setText(strCompLoc);
	}

	@Override
	boolean valid(WizardDescriptor descriptor) {
		if (isIllegalName(projectNameTextField.getText())) {
			descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE,
				NbBundle.getMessage(PanelConfigureProjectVisual.class, "msg.InvProjName"));
			return false;
		}

		File f = new File(projectLocationTextField.getText()).getAbsoluteFile();
		if (getCanonicalFile(f) == null) {
			String message = NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.IllegalProjLoc");
			descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
			return false;
		}

		// not allow to create project on unix root folder, see #82339
		File cfl = getCanonicalFile(new File(projectLocationTextField.getText()));
		if (Utilities.isUnix() && cfl != null && cfl.getParentFile().getParent() == null) {
			String message = NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.ProjInRootNotSupported");
			descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
			return false;
		}

		final File destFolder = new File( projectLocationTextField.getText() ).getAbsoluteFile();
		if (getCanonicalFile (destFolder) == null) {
			String message = NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.IllegalProjLoc");
			descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
			return false;
		}

		File projLoc = FileUtil.normalizeFile(destFolder);
		while (projLoc != null && !projLoc.exists()) {
			projLoc = projLoc.getParentFile();
		}
		if (projLoc == null || !projLoc.canWrite()) {
			String message = NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.ProjFolderReadOnly");
			descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
			return false;
		}

		try {
			ComponentDefinition compDef = new ComponentDefinition(componentFolder.getText());
			if (!compDef.validateComponentDef()) {
				String message = NbBundle.getMessage(PanelConfigureProjectVisual.class,
						"msg.InvalidCompDefXML");
				descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
				return false;
			}
			panelCompDef = compDef;
		} catch (IOException ex) {
			String message = NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.InvalidCompFolder");
			descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
			return false;
		}

		descriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "");
		return true;
	}

	@Override
	void validate(WizardDescriptor settings) throws WizardValidationException {
		String compStrFolder=componentFolder.getText();
		try {
			ComponentDefinition compDef = new ComponentDefinition(compStrFolder);
			if (compDef.validateComponentDef()){
				String compDefName=compDef.getComponentName();
				projectNameTextField.setText(compDefName);
			}
		} catch (IOException ex) {
			throw new WizardValidationException(this, ex.getMessage(),
					NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.InvalidCompFolder"));
		} catch (SAXException|XPathExpressionException ex) {
			throw new WizardValidationException(this, ex.getMessage(),
					NbBundle.getMessage(PanelConfigureProjectVisual.class,
					"msg.InvalidCompDefXML"));
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateTexts(e);
		if (this.componentFolder.getDocument() == e.getDocument()) {
			firePropertyChange(PROP_COMPONENT_LOCATION, null, this.componentFolder.getText());
		}
		if (this.projectNameTextField.getDocument() == e.getDocument()) {
			firePropertyChange(PROP_PROJECT_NAME, null, this.projectNameTextField.getText());
		}
		if (this.projectLocationTextField.getDocument() == e.getDocument()) {
			firePropertyChange (PROP_PROJECT_LOCATION,null,this.projectLocationTextField.getText());
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateTexts(e);
		if (this.componentFolder.getDocument() == e.getDocument()) {
			firePropertyChange(PROP_COMPONENT_LOCATION, null, this.componentFolder.getText());
		}
		if (this.projectNameTextField.getDocument() == e.getDocument()) {
			firePropertyChange(PROP_PROJECT_NAME, null, this.projectNameTextField.getText());
		}
		if (this.projectLocationTextField.getDocument() == e.getDocument()) {
			firePropertyChange (PROP_PROJECT_LOCATION,null,this.projectLocationTextField.getText());
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateTexts(e);
		if (this.componentFolder.getDocument() == e.getDocument()) {
			firePropertyChange(PROP_COMPONENT_LOCATION, null, this.componentFolder.getText());
		}
		if (this.projectNameTextField.getDocument() == e.getDocument()) {
			firePropertyChange(PROP_PROJECT_NAME, null, this.projectNameTextField.getText());
		}
		if (this.projectLocationTextField.getDocument() == e.getDocument()) {
			firePropertyChange (PROP_PROJECT_LOCATION,null,this.projectLocationTextField.getText());
		}
	}

	private void updateTexts (DocumentEvent e) {
		Document doc = e.getDocument();
		if (doc == componentFolder.getDocument()){
			try{
				if ((panelCompDef!=null) && (panelCompDef.validateComponentDef())){
					String compDefName=panelCompDef.getComponentName();
					projectNameTextField.setText(compDefName);
				}
			} catch (IOException|SAXException|XPathExpressionException ex) { }
		}
		if (doc == projectNameTextField.getDocument() ||
			doc == projectLocationTextField.getDocument()) {
			String projectName = projectNameTextField.getText();
			String projectFolder = projectLocationTextField.getText();
			createdFolderTextField.setText(projectFolder + File.separatorChar + projectName);
		}
		panel.fireChangeEvent(); // Notify that the panel changed
	}

	static File getCanonicalFile(File file) {
		try {
			return file.getCanonicalFile();
		} catch (IOException e) {
			return null;
		}
	}

	static boolean isIllegalName(final String name) {
		return name.length() == 0      || 
			name.indexOf('/')  >= 0 ||        //NOI18N
			name.indexOf('\\') >= 0 ||        //NOI18N
			name.indexOf(':')  >= 0 ||        //NOI18N
			name.indexOf("\"") >= 0 ||        //NOI18N
			name.indexOf('<')  >= 0 ||        //NOI18N
			name.indexOf('>')  >= 0;          //NOI18N
	}
}
