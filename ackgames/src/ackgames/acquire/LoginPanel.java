package ackgames.acquire;

import java.awt.*;

public class LoginPanel extends Panel
{
    Acquire m_acquire = null;

	public LoginPanel(Acquire a,String host,String port,String name)
	{

         m_acquire = a;
		//{{INIT_CONTROLS
		setLayout(null);
		setBackground(new Color(79,148,232));
		setSize(900,484);
		label1.setText("Name:");
		add(label1);
		label1.setForeground(Color.white);
		label1.setFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 12));
		label1.setBounds(234,132,46,24);
		m_loginPanel.setLabel("Login");
		add(m_loginPanel);
		m_loginPanel.setBackground(Color.lightGray);
		m_loginPanel.setBounds(276,312,60,24);
		add(m_name);
		m_name.setBounds(282,132,216,24);
		m_hostLabel.setText("Host:");
		add(m_hostLabel);
		m_hostLabel.setForeground(Color.white);
		m_hostLabel.setFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 12));
		m_hostLabel.setBounds(234,180,36,24);
		add(m_host);
		m_host.setBounds(282,180,216,24);
		m_portLabel.setText("Port:");
		add(m_portLabel);
		m_portLabel.setForeground(Color.white);
		m_portLabel.setFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 12));
		m_portLabel.setBounds(234,228,36,24);
		add(m_port);
		m_port.setBounds(282,228,84,24);
		label2.setText("Acquire");
		add(label2);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Serif", Font.ITALIC, 36));
		label2.setBounds(299,48,145,36);
		label3.setText("Copyright 1997-2017 AckPlay 2.0. All rights reserved.");
		add(label3);
		label3.setForeground(Color.white);
		label3.setFont(new Font("SansSerif", Font.ITALIC, 10));
		label3.setBounds(36,408,264,24);
		add(label4);
		label4.setForeground(Color.white);
		label4.setFont(new Font("SansSerif", Font.ITALIC, 12));
		label4.setBounds(408,336,252,24);
		error.setText("text");
		add(error);
		error.setForeground(Color.white);
		error.setFont(new Font("SansSerif", Font.BOLD, 16));
		error.setBounds(288,276,324,24);
		error.setVisible(false);
		//}}
        m_host.setText(host);
        m_port.setText(port);
        if(name != null){
            m_name.setText(name);
            
        }
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		m_loginPanel.addActionListener(lSymAction);
		m_name.addActionListener(lSymAction);
		//}}
	}
    void setErrorOn(String txt)
    {
        error.setText(txt);
        error.setVisible(true);
    }
    void setErrorOff()
    {
        error.setVisible(false);
    }
	//{{DECLARE_CONTROLS
	Label label1 = new Label();
	Button m_loginPanel = new Button();
	TextField m_name = new TextField();
	Label m_hostLabel = new Label();
	TextField m_host = new TextField();
	Label m_portLabel = new Label();
	TextField m_port = new TextField();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label error = new Label();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == m_loginPanel)
				mLoginPanel_ActionPerformed(event);
			else if (object == m_name)
				mName_ActionPerformed(event);
		}
	}

	void mLoginPanel_ActionPerformed(java.awt.event.ActionEvent event)
	{

        if(m_name.getText().trim().length()==0){
            setErrorOn(m_name.getText()+ " needs to  have at least 1 char");
            return;
        }
        if( m_name.getText().matches("^.*[^a-zA-Z0-9 ].*$")){
            setErrorOn(m_name.getText()+ " must only have alphanumerics");
            return;
        }
	     setErrorOff();
		 m_acquire.doit(m_name.getText().trim(),m_host.getText(),m_port.getText());
			 
	}

	void mName_ActionPerformed(java.awt.event.ActionEvent event)
	{
		mLoginPanel_ActionPerformed(null);
			 
	}

	
}