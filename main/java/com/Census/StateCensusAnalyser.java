import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public int loadCsvData(String csvFile) {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFile));) {
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();

			List<CSVStateCensus> censusList = new ArrayList<CSVStateCensus>();
			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			while (iterator.hasNext()) {
				censusList.add(iterator.next());
			}
			return censusList.size();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
}