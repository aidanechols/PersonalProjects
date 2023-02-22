import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_Selector implements ActionListener{

	private static ArrayList<Media> movies = new ArrayList<>();
	private JFrame frame;
	private JButton button;
	private JLabel movieLabel;
	private JLabel countLabel;
	private JLabel sortLabel;
	private JLabel filterLabel;
	private JPanel filterPanel;
	private JPanel genrePanel;
	private JPanel sortPanel;
	private JPanel countPanel;
	private JPanel buttonPanel;
	private JPanel moviePanel;
	private JTextField textField;
	private JComboBox<String> filterBox;
	private JComboBox<String> sortBox;
	private JRadioButton ascending;
	private JRadioButton descending;
	private JRadioButton random;
	
	public GUI_Selector() {

		
		ImageIcon Tatseguri = new ImageIcon("Tatseguri.jpg");
		
		String[] filters = getFilters(); //gets a list of filters from genre
		filterBox = new JComboBox<>(filters);
		
		filterLabel = new JLabel("Filter by Genre: ");
		filterLabel.setHorizontalAlignment(JLabel.LEFT);
		filterLabel.setVerticalAlignment(JLabel.CENTER);
		filterLabel.setForeground(new Color(0x00FF00));
		filterLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		genrePanel = new JPanel();
		genrePanel.setLayout(new FlowLayout());
		genrePanel.setBackground(new Color(0,50,250));
		genrePanel.add(filterLabel);
		genrePanel.add(filterBox);
		
		sortLabel = new JLabel("Sort by: ");
		sortLabel.setHorizontalAlignment(JLabel.LEFT);
		sortLabel.setVerticalAlignment(JLabel.CENTER);
		sortLabel.setForeground(new Color(0x00FF00));
		sortLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		String[] categories = {"Title", "Duration", "Release Year"};
		sortBox = new JComboBox<>(categories);
		
		ascending = new JRadioButton("Ascending");
		descending = new JRadioButton("Descending");
		random = new JRadioButton("Random");
		random.setSelected(true);//initializes Random as selected
		
		ButtonGroup sort = new ButtonGroup();
		sort.add(ascending);
		sort.add(descending);
		sort.add(random);
		
		sortPanel = new JPanel();
		sortPanel.setLayout(new FlowLayout());
		sortPanel.setBackground(new Color(0,50,250));
		sortPanel.add(sortLabel);
		sortPanel.add(sortBox);
		sortPanel.add(ascending);
		sortPanel.add(descending);
		sortPanel.add(random);
		
		countLabel = new JLabel("Number of Movies to Generate: ");
		countLabel.setHorizontalAlignment(JLabel.LEFT);
		countLabel.setVerticalAlignment(JLabel.CENTER);
		countLabel.setForeground(new Color(0x00FF00));
		countLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		textField = new JTextField("1",2);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setPreferredSize(new Dimension(20,20));
		
		countPanel = new JPanel();
		countPanel.setLayout(new FlowLayout());
		countPanel.setBackground(new Color(0,50,250));
		countPanel.add(countLabel);
		countPanel.add(textField);
		
		filterPanel = new JPanel();
		filterPanel.setLayout(new FlowLayout());
		filterPanel.setPreferredSize(new Dimension(700,150));
		filterPanel.setBackground(new Color(0,50,250)); //change background
		filterPanel.add(countPanel, BorderLayout.NORTH);
		filterPanel.add(sortPanel, BorderLayout.CENTER);
		filterPanel.add(genrePanel, BorderLayout.SOUTH);
		
		button = new JButton("Generate Movie");
		button.setVerticalAlignment(JButton.CENTER);
		button.addActionListener(this);
		
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(300,150));
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(new Color(123,50,250)); //change background
		buttonPanel.add(button, BorderLayout.CENTER);
				
		movieLabel = new JLabel("", SwingConstants.CENTER);
		movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		movieLabel.setVerticalAlignment(SwingConstants.TOP);
		movieLabel.setForeground(new Color(0x00FF00));
		movieLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		moviePanel = new JPanel();
		moviePanel.setPreferredSize(new Dimension(400,150));
		moviePanel.setLayout(new FlowLayout());
		moviePanel.setBackground(new Color(123,50,0)); //change background
		moviePanel.add(movieLabel);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close on exit
		frame.setSize(700,500); //set frame size
		frame.setTitle("Movie Selector"); //set title
		frame.setVisible(true); //make frame visible
		frame.add(filterPanel, BorderLayout.NORTH); //add contents
		frame.add(buttonPanel, BorderLayout.CENTER); //add contents
		frame.add(moviePanel, BorderLayout.EAST); //add contents
		frame.setIconImage(Tatseguri.getImage()); //change frame icon in top left corner

		
	}

	public static void main(String[] args) {
		
		//add list of movies
		movies.add(new Media("Tatseguri.jpg","Die Hard", 1988, 132, "Action", "Thriller", null, (float) 8.2, "Greatest Christmas movie of all time", 72, "John McTiernan",  "Bruce Willis", "Alan Rickman", "Bonnie Bedelia", "Reginald VelJohnson", 890850, 139434346));
		movies.add(new Media("Tatseguri.jpg","Die Hard 2", 1990, 124, "Action", "Thriller", null, (float) 7.1, "Second greatest Christmas movie of all time", 67, "Renny Harlin",  "Bruce Willis", "William Atherton", "Bonnie Bedelia", "Reginald VelJohnson", 367384, 239813888));
		movies.add(new Media("Tatseguri.jpg","Die Hard with a Vengance", 1995, 128, "Action", "Thriller", "Adventure", (float) 7.6, "Greatest Christmas movie of all time", 58, "John McTiernan",  "Bruce Willis", "Jeremy Irons", "Samuel L. Jackson", "Graham Greene", 392434, 366101666));
		movies.add(new Media("Tatseguri.jpg","Lord of the Rings The Fellowship of the Ring", 2001, 228, "Action", "Adventure", "Drama", (float) 8.8, "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.", 92, "Peter Jackson", "Elijah Wood", "Ian McKellen", "Orlando Bloom", "Sean Bean", 1887515, 891216824));
		movies.add(new Media("Tatseguri.jpg","Lord of the Rings The Two Towers", 2002, 235, "Action", "Adventure", "Drama", (float) 8.8, "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron's new ally, Saruman, and his hordes of Isengard.", 87, "Peter Jackson", "Elijah Wood", "Ian McKellen", "Viggo Mortensen", "Orlando Bloom", 1677813, 919148764));
		movies.add(new Media("Tatseguri.jpg","Lord of the Rings The Return of the King", 2003, 252,"Action", "Adventure", "Drama", (float) 9.0, "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", 94, "Peter Jackson", "Elijah Wood", "Viggo Mortensen", "Ian McKellen", "Orlando Bloom", 1858159, 1120210896));
		/*movies.add(new Media("Tatseguri.jpg","Harry Potter and the Sorcerers Stone", "Fantasy", 152, 13, 2001));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Chamber of Secrets", "Fantasy", 161, 13, 2002));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Prizoner of Azkaban", "Fantasy", 144, 13, 2004));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Goblet of Fire", "Fantasy", 157, 13, 2005));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Order of the Phoenix", "Fantasy", 138, 13, 2007));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Half-Blood Prince", "Fantasy", 153, 13, 2009));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Deathly Hallows - Part 1", "Fantasy", 146, 13, 2010));
		movies.add(new Media("Tatseguri.jpg","Harry Potter and the Deathly Hallows - Part 2", "Fantasy", 130, 13, 2011));
		movies.add(new Media("Tatseguri.jpg","The Hobbit: An Unexpected Journey", "Adventure", 169, 4, 2012));
		movies.add(new Media("Tatseguri.jpg","The Hobbit: The Desolation of Smaug", "Adventure", 161, 4, 2013));
		movies.add(new Media("Tatseguri.jpg","The Hobbit: The Battle of the Five Armies", "Adventure", 144, 3, 2014));
		movies.add(new Media("Tatseguri.jpg","Knives Out", "Mystery", 130, 1, 2019));
		movies.add(new Media("Tatseguri.jpg","Death on the Nile", "Mystery", 127, 2, 2022));
		*/
		
		new GUI_Selector();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {

			ArrayList<Media> temp = new ArrayList<>();
			ArrayList<Media> filtered;
			
			if(!filterBox.getSelectedItem().toString().equalsIgnoreCase("All")) {
				filtered = new ArrayList<>(filterList(filterBox.getSelectedItem().toString()));
			}else {
				filtered = new ArrayList<>(movies);
			}
			
			int n = Integer.parseInt(textField.getText()); //get number of movies to be generated
			if(n>filtered.size()) { n=filtered.size();} //check  and adjust size of list generated
			
			try{		
				if(random.isSelected()) {
				
					Random rand = new Random();
					
					int[] check = new int[n];//array to check for duplicates
					Arrays.fill(check, -1);//fill with id's that cannot be a list position
					
					for(int i = 0; i<n; i++) {			
						int r = rand.nextInt(filtered.size());//generate random list position
						boolean c = false;
						
						for (int j = 0; j<check.length; j++){
							if(check[j] == r) {//check for duplicates 
								c=true;
								break;
							}
						}
						
						if(!c) {
							check[i] = r;
							temp.add(new Media(filtered.get(r)));//if no duplicates, create a copy in temp list
						}
						else i--;//retry if duplicate found
					}
					
					movieLabel.setText(addText(n, temp));//use function to add multiple films
					 
				} else {
					if(sortBox.getSelectedItem().toString().equalsIgnoreCase("Title")) {
						Collections.sort(filtered, (o1, o2) -> (o1.getTitle().compareTo(o2.getTitle()))); //Sort by Title
						if(descending.isSelected()) {revlist(filtered);}
						movieLabel.setText(addText(n, filtered));//use function to add multiple films
					}
					if(sortBox.getSelectedItem().toString().equalsIgnoreCase("Duration")) {
						Collections.sort(filtered, Comparator.comparing(Media :: getDuration)); //Sort by Duration
						if(descending.isSelected()) {revlist(filtered);}
						movieLabel.setText(addText(n, filtered));//use function to add multiple films
					}
					if(sortBox.getSelectedItem().toString().equalsIgnoreCase("Release Year")) {
						Collections.sort(filtered, Comparator.comparing(Media :: getRelease)); //Sort by Release Year
						if(descending.isSelected()) {revlist(filtered);}
						movieLabel.setText(addText(n, filtered));//use function to add multiple films
					}
				}
			} catch (Exception x){
				movieLabel.setText("Invalid Selection"); //make sure movie count is a valid number
				}
		}
	}
	
	public static <T> void revlist(List<T> list)
    {
        // base condition when the list size is 0
        if (list.size() <= 1 || list == null)
            return;
 
       
        T value = list.remove(0);
       
        // call the recursive function to reverse
        // the list after removing the first element
        revlist(list);
 
        // now after the rest of the list has been
        // reversed by the upper recursive call,
        // add the first value at the end
        list.add(value);
    }
	
	private ArrayList<Media> filterList(String genre) {
		ArrayList<Media> filteredList = new ArrayList<>();
		
		for(int i = 0; i<movies.size(); i++) {	
			if(movies.get(i).getGenre1() != null && movies.get(i).getGenre1().equalsIgnoreCase(genre)) {
				filteredList.add(new Media(movies.get(i)));//add to list if is meets filter criteria
			}
			else if(movies.get(i).getGenre2() != null && movies.get(i).getGenre2().equalsIgnoreCase(genre)) {
				filteredList.add(new Media(movies.get(i)));//add to list if is meets filter criteria
			}
			else if(movies.get(i).getGenre3() != null && movies.get(i).getGenre3().equalsIgnoreCase(genre)) {
				filteredList.add(new Media(movies.get(i)));//add to list if is meets filter criteria
			}
		}
		return filteredList;
	}

	private String addText(int n, ArrayList<Media> list) {
		String text = "<html><div style='text-align: center;'>";//center and allow text to have new lines
		
		for (int i=0; i<n; i++) {
			text = text.concat("<br/>").concat(list.get(i).getTitle());//concat line breaks and new titles
		}
		text = text.concat("</div></html>");//close new text
		return text;
	}
	
	private String[] getFilters() {	
		String[] check = new String[69];//array of nice size to check for duplicates
		check[0] = "All";
		int counter = 1;//initialize an array position counter
		boolean unique; //initialize a boolean to account for duplicates
		String[] checker = new String[3];//initialize a string array to check all 3 possible genres listed
		
		for(int i = 0; i<movies.size(); i++) { //iterate over list of movies
			checker = movies.get(i).getGenres();//Assign current set of genres to array to be checked
			for(int j=0; j<checker.length; j++){//iterate over check array
				unique = true;//reset boolean
				for(int k=1; k<check.length; k++){
					if(check[k] == null) {//check if value exists
						break;
					}
					else if(checker[j] == null) {
						unique = false;
						break;
					}
					else if(check[k].equalsIgnoreCase(checker[j])){//check for duplicates
						unique = false;//if duplicate, set flag
						break;//break from k loop
					}
				}
				if(unique) { //check flag
					
					if(j==0) {check[counter] = movies.get(i).getGenre1();}//add unique genre
					else if(j==1) {check[counter] = movies.get(i).getGenre2();}//add unique genre
					else if(j==2) {check[counter] = movies.get(i).getGenre3();}//add unique genre
					counter++;//move to next array position
				}
			}
		}
	
		
		counter = 0;//reinitialize an array position counter
		while (check[counter] != null){
			counter++;//check for number of assigned positions
		}
		
		String[] returnable = new String[counter];//create smaller array with known size. This eliminates any blank null values being added
		
		for (int k=0; k<counter; k++) {
			returnable[k] = check[k]; //add completed list to be returned
		}
		return returnable;
	}
}
