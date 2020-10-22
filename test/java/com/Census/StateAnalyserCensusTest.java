import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class StateAnalyserCensusTest {
	public static final String STATE_CENSUS_DATA_FILE = "F:\\Capgemini_training1\\java_eclipse\\IndiaStateCensusAnalyser"
			+ "\\IndiaStateCensusData.csv";
	public static final String WRONG_STATE_CENSUS_DATA_FILE = "F:\\Capgemini_training1\\java_eclipse\\IndiaStateCensusAnalyser"
			+ "\\IndiaStateCensusData.cv";

	public static final String WRONG_HEADER_IN_CENSUS_FILE = "F:\\Capgemini_training1\\java_eclipse\\IndiaStateCensusAnalyser\\IndiaStateCode.csv";


	@Test
	public void whenNumberOfRecordMatchesShouldPassTest() throws CustomCensusAnalyserException, IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		int totalEntriesInCsvFile = stateCensusAnalyser.loadCsvData(STATE_CENSUS_DATA_FILE);
		Assert.assertEquals(29, totalEntriesInCsvFile);
	}

	@Test
	public void whenFileIsNotInCsvFormatShouldThrowCustomException() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int totalEntriesInCsvFile = stateCensusAnalyser.loadCsvData(WRONG_STATE_CENSUS_DATA_FILE);
		} catch (CustomCensusAnalyserException e) {
			Assert.assertEquals(CustomCensusAnalyserException.ExceptionType.IncorrectCsvFile, e.type);
		}
	}

	@Test
	public void whenFileDataIsImproperShouldThrowCustomException() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int totalEntriesInCsvFile = stateCensusAnalyser.loadCsvData(WRONG_DATA_IN_CENSUS_FILE);
		} catch (CustomCensusAnalyserException e) {
			Assert.assertEquals(CustomCensusAnalyserException.ExceptionType.IncorrectData, e.type);
		}
	}


	public void whenFileHeaderIsImproperShouldThrowCustomException() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int totalEntriesInCsvFile = stateCensusAnalyser.loadCsvData(WRONG_HEADER_IN_CENSUS_FILE);
		} catch (CustomCensusAnalyserException e) {
			Assert.assertEquals(CustomCensusAnalyserException.ExceptionType.IncorrectData, e.type);
		}
	}
}
