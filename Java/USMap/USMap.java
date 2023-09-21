import java.util.Scanner;

/*
 * @author Khushi Chetty
 * @since September 5 2023
 */

public class USMap
{
	private Scanner readIn = null;
	private Scanner readIn2 = null;
	public static void main(String []args)
	{
		USMap map1 = new USMap();
		
		map1.setupCanvas();
		map1.readAndDraw();
	
	}
	public void readAndDraw()
	{
		readIn = FileUtils.openToRead("cities.txt");
		
		while (readIn.hasNextLine())
		{
			String str = readIn.nextLine();
			double num1 = readIn.nextDouble();
			double num2 = readIn.nextDouble();
			String city = readIn.nextLine();
			int index2 = city.lastIndexOf(",");
			String cityName = city.substring(0, index2);
			checkIfCityInList(cityName, num1, num2);
		}	
	}
	public void checkIfCityInList(String cityIn, double num1, double num2)
	{
		boolean redCity= false;
		boolean bluecity=false;
		boolean regular= false;
		boolean found = false;
		String nameCity = cityIn;
		double num1In = num1;
		double num2In = num2;
		readIn2 = FileUtils.openToRead("bigCities.txt");
		while (readIn2.hasNext()&& !found )
		{
			
			
			String getLine = readIn2.nextLine();
			int index = getLine.indexOf(" ");
			String line2 = getLine.substring(0, index);
			int rank = Integer.parseInt(line2);
			int index1 = getLine.lastIndexOf(" ")+1;
			String line3 = getLine.substring(index1, getLine.length());
			int population = Integer.parseInt(line3);
			String  line = getLine.substring(index,index1);
			if (rank <= 10 && line.trim().equals(nameCity))
			{
				found = true;
				redCity = true;
				StdDraw.setPenColor(StdDraw.RED);
				double val = 0.6 * (Math.sqrt(population)/18500);
				StdDraw.setPenRadius(val);
				StdDraw.point(num2In, num1In);
				found = true;
			}
			else if (line.equals(nameCity))
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				double val2 = 0.6 * (Math.sqrt(population)/18500);
				StdDraw.setPenRadius(val2);
				StdDraw.point(num2In, num1In);
			}
			else
			{
				StdDraw.setPenRadius(0.006);
				StdDraw.point(num2In, num1In);
				
			}
		
			
		}
		
	}
	public void setupCanvas()
	{
		StdDraw.setTitle("USMap");
		StdDraw.setCanvasSize(900, 512);
		StdDraw.setXscale(128.0, 65.0);
		StdDraw.setYscale(22.0, 52.0);
	}
}
