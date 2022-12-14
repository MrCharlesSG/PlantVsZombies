package tp1.p2.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import tp1.p2.control.Level;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.RecordException;
import tp1.p2.view.Messages;

public class Record {

	private Level level;
	public int currentRecord;
	
	public Record(Level level, int record) {
		this.level=level;
		this.currentRecord=record;
	}
	
	public Record setRecord(Record scanner) {
		this.currentRecord = scanner.currentRecord;
		return this;
	}
	
	public Record loadRecord(Level level) throws GameException {
		
		String filename = "record.txt";
		File file = new File(filename);
		boolean encontrado = false;
		
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNext() && !encontrado) {
				String tokens[] = scanner.nextLine().split(":");
				
				if(tokens[0].equalsIgnoreCase(level.name())) {
					this.currentRecord = (int) Integer.parseInt(tokens[1]);
					encontrado=true;
				}
			}
			
		}
		catch (FileNotFoundException e){
			throw new RecordException(Messages.ERROR_READING_FILE);
		}
		return this;
	}
	
	public void saveRecord() throws RecordException {
		String filename = "record.txt";
		String actualizarRecord="";
		File file = new File(filename);
		boolean encontrado=false;
		
		try(Scanner scanner = new Scanner(file)){
			while(scanner.hasNext()) {
				String tokens[]=scanner.nextLine().split(":");
				if(tokens[0].equalsIgnoreCase(level.name())) {
					int record=(int) Integer.parseInt(tokens[1]);
					if(record < this.currentRecord) {
						tokens[1] = this.currentRecord + "";
					}
					encontrado=true;
				}
				actualizarRecord += tokens[0] + ":" + tokens[1] + "\n";
			}
			if(!encontrado) {
				actualizarRecord += level.name() + ":" + "0" + "\n";
			}
			FileOutputStream os = new FileOutputStream(filename);
			OutputStreamWriter osWriter = new OutputStreamWriter(os);
			Writer w = new BufferedWriter(osWriter);
			w.write(actualizarRecord);
			w.close();
			
		}
		catch(IOException e) {
			throw new RecordException();
		}
	}

	public String getLevelName() {
		return this.level.name();
	}
	
	public int getCurrentRecord() {
		if(this.level!=null) {
			return this.currentRecord;
		}
		return 0;
		
	}
	
}
