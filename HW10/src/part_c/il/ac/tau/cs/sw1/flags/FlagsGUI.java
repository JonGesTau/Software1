package part_c.il.ac.tau.cs.sw1.flags;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class FlagsGUI {

	private static final int MAX_ERRORS = 3;
	private Shell shell;
	private Label scoreLabel;
	private Composite questionPanel;
	private Label startupMessageLabel;
	private Font boldFont;
	
	String filePath;
	String directory;
	HashMap<String, String> flagsMap = new HashMap<>();
	List<String> flagsList = new ArrayList<String>();
	int score;
	int errors;
	int rightAnswers;
	String currentCountry;
	boolean passButtonClicked = false;
	boolean getALetterButtonClicked = false;
	
	// Currently visible UI elements.
	Label instructionLabel;
	Label flagImageLabel;
	Text countryGuessText;
	
	private Button passButton;
	private Button getALetterButton;

	public void open() {
		createShell();
		runApplication();
	}

	/**
	 * Creates the widgets of the application main window
	 */
	private void createShell() {
		Display display = Display.getDefault();
		shell = new Shell(display);
		shell.setText("Capture the Flags");

		// window style
		Rectangle monitor_bounds = shell.getMonitor().getBounds();
		shell.setSize(new Point(monitor_bounds.width / 3,
				monitor_bounds.height / 2));
		shell.setLayout(new GridLayout());

		FontData fontData = new FontData();
		fontData.setStyle(SWT.BOLD);
		boldFont = new Font(shell.getDisplay(), fontData);

		// create window panels
		createFileLoadingPanel();
		createScorePanel();
		createQuestionPanel();
	}

	/**
	 * Creates the widgets of the form for flags file selection
	 */
	private void createFileLoadingPanel() {
		final Composite fileSelection = new Composite(shell, SWT.NULL);
		fileSelection.setLayoutData(GUIUtils.createFillGridData(1));
		fileSelection.setLayout(new GridLayout(4, false));

		final Label label = new Label(fileSelection, SWT.NONE);
		label.setText("Enter flags file path: ");

		// text field to enter the file path
		final Text filePathField = new Text(fileSelection, SWT.SINGLE
				| SWT.BORDER);
		filePathField.setLayoutData(GUIUtils.createFillGridData(1));

		// "Browse" button
		final Button browseButton = new Button(fileSelection, SWT.PUSH);
		browseButton.setText("Browse");
		
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof Button) {
					filePath = GUIUtils.getFilePathFromFileDialog(shell);
					filePathField.setText(filePath);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// "Play!" button
		final Button playButton = new Button(fileSelection, SWT.PUSH);
		playButton.setText("Play!");
		
		playButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof Button) {
					try {
						File file = new File(filePath);
						FileReader fileReader = new FileReader(file);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						StringBuffer stringBuffer = new StringBuffer();
						String line;
						int count = 0;
						int numFlags = 0;
						while ((line = bufferedReader.readLine()) != null) {
							count++;
							if (count == 1) {
								numFlags = Integer.parseInt(line);
							} else if (!line.isEmpty()) {
								String name = line.split(".png,")[1];
								String path = line.split(",")[0];
								flagsMap.put(name, path);
							}
						}
						fileReader.close();
						
						flagsList = new ArrayList<String>(flagsMap.keySet());
						Collections.shuffle(flagsList);
						directory = new File(filePath).getParent();
						nextFlag();
						
						score = 0;
						errors = 0;
						
						setScoreText();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Creates the panel that displays the current score
	 */
	private void createScorePanel() {
		Composite scorePanel = new Composite(shell, SWT.BORDER);
		scorePanel.setLayoutData(GUIUtils.createFillGridData(1));
		scorePanel.setLayout(new GridLayout(2, false));

		final Label label = new Label(scorePanel, SWT.NONE);
		label.setText("Total score: ");

		// The label which displays the score; initially empty
		scoreLabel = new Label(scorePanel, SWT.NONE);
		scoreLabel.setLayoutData(GUIUtils.createFillGridData(1));
	}

	/**
	 * Creates the panel that displays the flag image, as soon as the game
	 * starts. See the updateQuestionPanel for creating the flag image and input box for answer
	 */
	private void createQuestionPanel() {
		questionPanel = new Composite(shell, SWT.BORDER);
		questionPanel.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true));
		questionPanel.setLayout(new GridLayout(2, true));

		// Initially, only displays a message
		startupMessageLabel = new Label(questionPanel, SWT.NONE);
		startupMessageLabel.setText("No flag to display, yet.");
		startupMessageLabel.setLayoutData(GUIUtils.createFillGridData(2));
	}
	
	private void setScoreText() {
		scoreLabel.setText(Integer.toString(score));
	}
	
	private void nextFlag() {
		if (errors == 3 || flagsList.isEmpty()) {
			GUIUtils.showInfoDialog(shell, "Score", "Your final score is " + score + " after " + (rightAnswers + errors) + " questions.");
			return;
		} else {
			String country = currentCountry = flagsList.remove(0);
			String flagPath = directory + "/" + flagsMap.get(country);
			updateQuestionPanel(flagPath, country);
		}
	}

	/**
	 * Serves to display the flag image and input box for answer
	 */
	private void updateQuestionPanel(String flagImageFullPath, String countryName) {
		// clear the panel
		Control[] children = questionPanel.getChildren();
		for (Control control : children) {
			control.dispose();
		}

		// create the instruction label
		instructionLabel = new Label(questionPanel, SWT.CENTER | SWT.WRAP);
		instructionLabel.setText("Guess the country for the following flag:");
		instructionLabel.setLayoutData(GUIUtils.createFillGridData(2));

		
		// create the flag image:
		Image flagImage = new Image(Display.getCurrent(), flagImageFullPath);
		flagImageLabel = new Label(questionPanel, SWT.CENTER | SWT.WRAP);
		flagImageLabel.setImage(flagImage);
		flagImageLabel.setLayoutData(GUIUtils.createFillGridData(2));
		

		// create the answer buttons
		Text answerGuessText = new Text(questionPanel, SWT.SINGLE| SWT.BORDER);
		answerGuessText.setText("Guess...");
		answerGuessText.setLayoutData(GUIUtils.createFillGridData(1));
		
		Button checkAnswerButton = new Button(questionPanel, SWT.PUSH | SWT.WRAP);
		checkAnswerButton.setText("Check");
		GridData answerLayoutData = GUIUtils.createFillGridData(1);
		answerLayoutData.verticalAlignment = SWT.FILL;
		checkAnswerButton.setLayoutData(answerLayoutData);
		
		checkAnswerButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof Button) {
					if (answerGuessText.getText().toLowerCase().equals(currentCountry.toLowerCase())) {
						score += 3;
						rightAnswers++;
					} else {
						score -= 2;
						errors++;
					}
					setScoreText();
					
					if (passButtonClicked && score < 0) {
						passButton.setEnabled(false);
						nextFlag();
					} else {
						nextFlag();
					}
				}
			}
		});
		
		// create the "Pass" button to skip a question
		passButton = new Button(questionPanel, SWT.PUSH);
		passButton.setText("Pass");
		GridData data = new GridData(GridData.END, GridData.CENTER, true,
				false);
		data.horizontalSpan = 1;
		passButton.setLayoutData(data);
		
		passButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof Button) {
					if (!passButtonClicked) {
						passButtonClicked = true;
					} else {
						score --;
						setScoreText();
					}
					nextFlag();
				}
			}
		});
		
		// create the "Get-a-Letter" button to show a letter
		getALetterButton = new Button(questionPanel, SWT.PUSH);
		getALetterButton.setText("Get-a-Letter");
		data = new GridData(GridData.BEGINNING, GridData.CENTER, true,
				false);
		data.horizontalSpan = 1;
		getALetterButton.setLayoutData(data);
		
		getALetterButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof Button) {
					if (!getALetterButtonClicked) {
						getALetterButtonClicked = true;
					} else {
						score --;
						setScoreText();
					}
					int randomNum = ThreadLocalRandom.current().nextInt(0, currentCountry.length());
					char letter = currentCountry.charAt(randomNum);
					
					GUIUtils.showInfoDialog(shell, "Get-a-Letter", "Letter number " + (randomNum + 1) + " is " + letter);
				}
			}
		});

		// two operations to make the new widgets display properly
		questionPanel.pack();
		questionPanel.getParent().layout();
				
	}

	/**
	 * Opens the main window and executes the event loop of the application
	 */
	private void runApplication() {
		shell.open();
		Display display = shell.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		boldFont.dispose();
	}
}
