import java.io. * ;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;
import java.time.format.DateTimeFormatter;

class CSVMotionData{
    //double index,timeStamp,interval,accX,accY,accZ,accGX,accGY,accGZ,rotRateAlpha,rotRateBeta,rotRateGamma,sqrtModule,relativeTimeStamp;
    double accX,accY,accZ,sqrtModule;
    Timestamp relativeTimeStamp;
}
class CSVOrientationData{
    boolean abs;
    double alpha,beta,gamma,sqrtModule, relativeTimeStamp;
}
class CSVData{
    Vector<CSVMotionData> csvMotionData;
    Vector<CSVOrientationData> csvOrientationData;
}
class ProcesesedData{
    double timeStamp,dataValue;
}






//Paths
//"C:\\Users\\erikb\\Downloads\\filtered\\user_1\\1_1\\user1_1_motion.csv"
//"C:\\Users\\erikb\\Downloads\\filtered\\user_1\\1_1\\user1_1_orientation.csv"
public class Main {
    public static void main(String[] args) throws Exception {
        new Main();
    }
    public Main()
    {
        CSVData csvData = ReadCSVIntoMemory("C:/user1_1_motion.csv","C:/user1_1_orientation.csv");
    }


    //OBS!!! THIS PART NEEDS TO BE WOKED ON!
    public void ComputeStatistics(CSVData csvData)
    {
        for (int i =0;i<csvData.csvMotionData.size();i++)
        {
            System.out.print(csvData.csvMotionData.elementAt(i).relativeTimeStamp);
            System.out.print(" ");
        }
    }

    //OBS!!! THIS PART NEEDS TO BE WOKED ON!
    public void  dateTimeToTimeDelta(String dateTime)
    {
        LocalDate parsedDate = LocalDate.now();
        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("d 'days' HH:mm:ss:n");
        String text = parsedDate.format(dataTimeFormatter);
        LocalDate parsedDate2 = LocalDate.parse(dateTime, dataTimeFormatter);
        System.out.print(parsedDate2);
    }
    public CSVData ReadCSVIntoMemory(String motionPath, String orientationPath)
    {
        CSVData csvData = new CSVData();
        csvData.csvMotionData = ReadCSVMotionIntoMemory(motionPath);
        csvData.csvOrientationData = ReadCSVOrientationIntoMemory(orientationPath);
        return csvData;
    }

    public Vector<CSVMotionData> ReadCSVMotionIntoMemory(String motionPath)
    {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(motionPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(",|\\n");
        //setting comma as delimiter pattern

        //discarding the identifiers
        for (int i = 0; i<13;i++)
        {
            sc.next();
        }

        int counter=0;
        Vector<CSVMotionData> csvMotionDataVector = new Vector<CSVMotionData>();
        csvMotionDataVector.clear();
        while (sc.hasNext())
        {
            switch(counter)
            {
                case 0 :
                    csvMotionDataVector.add(new CSVMotionData());
                    sc.next();
                    //csvMotionDataVector.lastElement().index = Double.parseDouble(sc.next());
                    break;
                case 1 :
                    sc.next();
                    //csvMotionDataVector.lastElement().timeStamp = new Timestamp(sc.next());
                    break;
                case 2 :
                    sc.next();
                    //csvMotionDataVector.lastElement().interval = Double.parseDouble(sc.next());
                    break;
                case 3 :
                    csvMotionDataVector.lastElement().accX = Double.parseDouble(sc.next());
                    //System.out.print(csvMotionDataVector.lastElement().accX +'\n');
                    break;
                case 4 :
                    csvMotionDataVector.lastElement().accY = Double.parseDouble(sc.next());
                    //System.out.print(csvMotionDataVector.lastElement().accY +'\n');
                    break;
                case 5 :
                    csvMotionDataVector.lastElement().accZ = Double.parseDouble(sc.next());
                    //System.out.print(csvMotionDataVector.lastElement().accZ +'\n');
                    break;
                case 6 :
                    sc.next();
                    //csvMotionDataVector.lastElement().accGX = Double.parseDouble(sc.next());
                    break;
                case 7 :
                    sc.next();
                    //csvMotionDataVector.lastElement().accGY = Double.parseDouble(sc.next());
                    break;
                case 8 :
                    sc.next();
                    //csvMotionDataVector.lastElement().accGZ = Double.parseDouble(sc.next());
                    break;
                case 9 :
                    sc.next();
                    //csvMotionDataVector.lastElement().rotRateAlpha = Double.parseDouble(sc.next());
                    break;
                case 10 :
                    sc.next();
                    //csvMotionDataVector.lastElement().rotRateBeta = Double.parseDouble(sc.next());
                    break;
                case 11 :
                    sc.next();
                    //csvMotionDataVector.lastElement().rotRateGamma = Double.parseDouble(sc.next());
                    break;
                case 12 :
                    csvMotionDataVector.lastElement().sqrtModule = Double.parseDouble(sc.next());
                    //System.out.print(csvMotionDataVector.lastElement().sqrtModule +'\n');
                    break;
                case 13 :
                    //csvMotionDataVector.lastElement().relativeTimeStamp = new Timestamp(sc.next());
                    dateTimeToTimeDelta(sc.next());
                    System.out.print('\n');
                    counter=-1;
                    break;
            }
            counter++;
        }
        sc.close();
        //closes the scanner
        return csvMotionDataVector;
    }

    public Vector<CSVOrientationData> ReadCSVOrientationIntoMemory(String orientationPath)
    {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(orientationPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(",|\\n");
        //setting comma as delimiter pattern

        //discarding the identifiers
        for (int i = 0; i<7;i++)
        {
            System.out.print(sc.next());
            //sc.next();
        }

        int counter=0;
        Vector<CSVOrientationData> csvOrientationDataVector = new Vector<CSVOrientationData>();
        csvOrientationDataVector.clear();
        while (sc.hasNext())
        {
            switch(counter)
            {
                case 0 :
                    csvOrientationDataVector.add(new CSVOrientationData());
                    sc.next();
                    //csvOrientationDataVector.lastElement().index = Double.parseDouble(sc.next());
                    break;
                case 1 :
                    sc.next();
                    //csvOrientationDataVector.lastElement().timeStamp = Double.parseDouble(sc.next());
                    break;
                case 2 :
                    if (sc.next() == "FALSE")
                    {
                        csvOrientationDataVector.lastElement().abs = false;
                    }
                    else
                    {
                        csvOrientationDataVector.lastElement().abs = true;
                    }
                    break;
                case 3 :
                    csvOrientationDataVector.lastElement().alpha = Double.parseDouble(sc.next());
                    break;
                case 4 :
                    csvOrientationDataVector.lastElement().beta = Double.parseDouble(sc.next());
                    break;
                case 5 :
                    csvOrientationDataVector.lastElement().gamma = Double.parseDouble(sc.next());
                    break;
                case 6 :
                    csvOrientationDataVector.lastElement().sqrtModule = Double.parseDouble(sc.next());
                    break;
                case 7 :
                    //csvOrientationDataVector.lastElement().relativeTimeStamp = Double.parseDouble(sc.next());
                    dateTimeToTimeDelta(sc.next());
                    System.out.print('\n');
                    counter=-1;
                    break;
            }
            counter++;
        }
        sc.close();
        //closes the scanner
        return csvOrientationDataVector;
    }
}
