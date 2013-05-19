package tla.vku.agentarena;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class CsvConvert {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File inputFile = new File("C:\\Users\\Trajche\\Desktop\\DMC2013_task\\transact_class.txt");
		File outputFile = new File("C:\\Users\\Trajche\\Desktop\\DMC2013_task\\csv_transact_class.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
		String line = null;
		long count = 0;
		while ((line = br.readLine()) != null) {
			String newLine = StringUtils.replaceChars(line, '|', ',');
			bw.write(newLine + IOUtils.LINE_SEPARATOR);
			count++;
			if (count % 10000 == 0) {
				System.out.println(count);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
