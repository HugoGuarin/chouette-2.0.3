package fr.certu.chouette.exchange.csv.importer.producer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;
import fr.certu.chouette.exchange.csv.exception.ExchangeException;
import fr.certu.chouette.exchange.csv.exception.ExchangeExceptionCode;
import fr.certu.chouette.model.neptune.NeptuneIdentifiedObject;

public abstract class AbstractModelProducer<T extends NeptuneIdentifiedObject> implements IModelProducer<T>
{
   public static final int TITLE_COLUMN = 7;
   
   private static final SimpleDateFormat  dfHM = new SimpleDateFormat("HH:mm") ;
   private static final SimpleDateFormat dfHMS = new SimpleDateFormat("HH:mm:ss") ;


   /**
    * load simple value in CSV row
    * 
    * @param csvReader
    *           reader
    * @param title
    *           label for value
    * @return value
    * @throws ExchangeException
    *            title not found
    */
   protected String loadStringParam(CSVReader csvReader, String title) throws ExchangeException
   {
      String[] currentLine = null;
      try
      {
         currentLine = csvReader.readNext();
      }
      catch (IOException e)
      {
         throw new ExchangeException(ExchangeExceptionCode.INVALID_CSV_FILE, e);
      }
      if (currentLine[TITLE_COLUMN].equals(title))
      {
         return currentLine[TITLE_COLUMN + 1];
      }
      else
      {
         throw new ExchangeException(ExchangeExceptionCode.INVALID_CSV_FILE, "Unable to read '" + title
               + "' in csv file , " + currentLine[TITLE_COLUMN] + " found");
      }
   }

   /**
    * extract CSV cell as String
    * 
    * @param column
    *           column rank
    * @param csvLine
    *           csv row
    * @return extracted value (null if not found or invalid format)
    */
   protected final String getValue(int column, String[] csvLine)
   {
      if (!csvLine[column].trim().isEmpty())
         return csvLine[column].trim();
      return null;
   }

   /**
    * extract CSV cell as integer
    * 
    * @param column
    *           column rank
    * @param csvLine
    *           csv row
    * @param defaultValue
    *           value if missing
    * @return extracted defaultValue (null if not found)
    */
   protected final int getIntValue(int column, String[] csvLine, int defaultValue)
   {
      if (csvLine[column].trim().isEmpty())
         return defaultValue;
      return Integer.parseInt(csvLine[column].trim());
   }

   /**
    * extract CSV cell as double
    * 
    * @param column
    *           column rank
    * @param csvLine
    *           csv row
    * @param defaultValue
    *           value if missing
    * @return extracted defaultValue (null if not found)
    */
   protected final double getDoubleValue(int column, String[] csvLine, double defaultValue)
   {
      if (csvLine[column].trim().isEmpty())
         return defaultValue;
      return Double.parseDouble(csvLine[column].trim());
   }

   /**
    * extract CSV cell as BigDecimal
    * 
    * @param column
    *           column rank
    * @param csvLine
    *           csv row
    * @return extracted value (null if not found or invalid format)
    */
   protected final BigDecimal getBigDecimalValue(int column, String[] csvLine)
   {
      if (csvLine[column].trim().isEmpty())
         return null;
      double value = Double.parseDouble(csvLine[column].trim());
      return new BigDecimal(value);
   }

   public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

   /**
    * extract CSV cell as date
    * 
    * @param column
    *           column rank
    * @param csvLine
    *           csv row
    * @param logger
    *           to log errors
    * @return extracted value (null if not found or invalid format)
    */
   protected final Date getDateValue(int column, String[] csvLine, Logger logger)
   {
      if (csvLine[column].trim().isEmpty())
         return null;
      try
      {
         return new Date(sdf.parse(csvLine[column].trim()).getTime());
      }
      catch (ParseException e)
      {
         logger.error(column + ": unable to parse date " + csvLine[column]);
         return null;
      }
   }

   /**
    * extract CSV cell as time
    * 
    * @param column
    *           column rank
    * @param csvLine
    *           csv row
    * @param logger
    *           to log errors
    * @return extracted value (null if not found or invalid format)
    */
   protected final Time getTimeValue(int column, String[] csvLine) throws ExchangeException
   {
      if (csvLine[column].trim().isEmpty())
         return null;
      String dateString = csvLine[column].trim();
      String token[] = dateString.split(":");
      if (token.length < 2 || token.length > 3) throw new ExchangeException(ExchangeExceptionCode.INVALID_CSV_FILE, "Invalid Time format : "+dateString);
      try
      {
         java.util.Date d =  null;
         if (token.length == 2)
         {

            d = dfHM.parse(dateString);

         }
         else
         {
            d = dfHMS.parse(dateString);
         }
         Time time = new Time(d.getTime());
         
         return time;
      }
      catch (ParseException e)
      {
         throw new ExchangeException(ExchangeExceptionCode.INVALID_CSV_FILE, "Invalid Time format : "+dateString);
      }

   }

   protected String toIdString(String input)
   {
      String output = input.replaceAll("[^0-9A-Za-z_\\-]", "_");
      return output;
   }
   
   /**
    * check if csv line has no data
    * 
    * @param data
    * @return true if  empty
    */
   public boolean checkLine(String[] data)
   {
      if (data == null)
         return true;
      for (String item : data)
      {
         if (item != null && !item.trim().isEmpty())
            return false;
      }
      return true;
   }


}
