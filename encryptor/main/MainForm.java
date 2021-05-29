package encryptor.main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import encryptor.utility.ClipBoardUtility;
import encryptor.utility.Encryptor;
import encryptor.utility.FileChooser;
import encryptor.utility.FileReader;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class MainForm {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text1;
	private Text text2;
	private Text textKey;
	private int height = 600;
	private int width = 600;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {	
		try {
			MainForm window = new MainForm();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setSize(width, height);
		shell.setText("Encryptor");
		shell.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - height/2);
		
		Button button = formToolkit.createButton(shell, "\u52A0\u5BC6/\u89E3\u5BC6", SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int key = 0;
				try {
					try {
						key = Integer.valueOf(textKey.getText());
						text2.setText(Encryptor.enrypt(text1.getText(), key));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "key請輸入有效數字","警告", JOptionPane.WARNING_MESSAGE, null);
					}
				} catch (Exception e2) {
					
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("微軟正黑體", 22, SWT.NORMAL));
		button.setBounds(210, 41, 180, 60);
		
		Label lblKey = formToolkit.createLabel(shell, "Key(\u8ACB\u8F38\u5165\u6578\u5B57):", SWT.NONE);
		lblKey.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblKey.setFont(SWTResourceManager.getFont("Microsoft JhengHei UI", 18, SWT.NORMAL));
		lblKey.setBounds(100, 107, 238, 44);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel.setBounds(10, 524, 92, 19);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("\u88FD\u4F5CBy\u694A\u5176\u9F8D");
		
		text1 = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text1.setBounds(10, 171, 270, 320);
		formToolkit.adapt(text1, true, true);
		
		text2 = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text2.setEditable(false);
		text2.setBounds(300, 171, 270, 320);
		formToolkit.adapt(text2, true, true);
		
		textKey = new Text(shell, SWT.BORDER);
		textKey.setBounds(344, 107, 134, 49);
		formToolkit.adapt(textKey, true, true);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setFont(SWTResourceManager.getFont("微軟正黑體", 15, SWT.BOLD));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ClipBoardUtility.CopyToClipBoard(text2.getText());
			}
		});
		button_1.setBounds(361, 498, 162, 34);
		formToolkit.adapt(button_1, true, true);
		button_1.setText("\u8907\u88FD\u5230\u526A\u8CBC\u7C3F");
		
		Button btntxt = formToolkit.createButton(shell, "\u532F\u5165\u6587\u5B57(\u9650.txt)", SWT.NONE);
		btntxt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				File selectedFile = FileChooser.chooseFile();
				if(selectedFile != null) {
				try {
					text1.setText(FileReader.getString(selectedFile));
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "請匯入有效檔案", "警告", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
				}
			}
		});
		btntxt.setBounds(0, 0, 582, 29);
		
		
	}
}


