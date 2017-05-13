package uebung1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import uebung1.FileIntArray;

/*********************************************************************
 * Erste praktische Übung von Algorithmen SS17 - Merge Sort Verbunden mit
 * einlesen von Datein, die Werte vorgegeben haben
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili
 *********************************************************************/
public class MergeSort {
	private int[] sortArray;
	private int[] helpArray;
	private int number;
	public static int count = 0;

	public static void main(String[] args) {
//		 int[] zahlenfolge = { 5, 9, 1, 4, 6, 7, 3, 2, 8 }; // Selbst gewählte Zahlen
		// int[] zahlenfolge2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // Selbst gewählte Zahlen
		// int[] zahlenfolge = readArray("src/uebung1/beispiele/Rand500_1"); // Aus einer Datei ausgelesene Zahlen

		System.out.println("			    --Merge Sort--");
		System.out.println("***************************************************************************");

		MergeSort mSort = new MergeSort();
		
//		mSort.sort(zahlenfolge);
		mSort.sort(FileIntArray.FileToIntArray("src/uebung1/beispiele/Rand1000_1"));
//		mSort.sort(FileIntArray.FileToIntArray("src/uebung1/beispiele/Sort1000_1"));

	}

	/*********************************************************************
	 * Kunstruktor für die Mergesort Methode, der das unsortierte und sortierte
	 * Array in der Konsole ausgibt
	 * 
	 * @param values - Das übergebene, unsortierte, Array
	 *********************************************************************/
	private void sort(int[] values) {
		this.count = 0;
		this.sortArray = values;
		this.number = values.length;
		this.helpArray = new int[number];
		long start = new Date().getTime();

		System.out.print("Eingabe:	");
		for (int i = 0; i <= number - 1; i++) {
			System.out.print(sortArray[i] + " ");
		}
		System.out.println("");
		mergeSort(0, number - 1);

		System.out.print("Sortiert:	");
		for (int i = 0; i <= number - 1; i++) {
			System.out.print(sortArray[i] + " ");
		}

		long runningTime = new Date().getTime() - start;
		System.out.println("");
		System.out.println("Durchläufe:	" + count);
		System.out.println("Benötigte Zeit: " + runningTime + " Millisekunden");
		System.out.println("---------------------------------------------------------------------------");
	}

	/*********************************************************************
	 * Funktion teilt das Array anhand der mitte in mehrere Teilarrays, bis
	 * jedes Element einzeln steht und fügt sie dann wieder sortiert zusammen
	 * 
	 * @param low - der kleinste Index im Array
	 * @param high - der größte Index im Array
	 *********************************************************************/
	private void mergeSort(int low, int high) {
		if (low < high) {
			int mid = (high + low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	/*********************************************************************
	 * Funktion um die einzelnen Elemente der Arrays miteiner vergleicht und
	 * wieder in einem sortierten Array zusammenzufügt
	 * 
	 * @param low - der kleinste Index im Array
	 * @param mid - die Mitte der Arrays
	 * @param high - der größte Index im Array
	 *********************************************************************/
	private void merge(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			helpArray[i] = sortArray[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (helpArray[i] <= helpArray[j]) {
				sortArray[k] = helpArray[i];
				i++;
				count++;
			} else {
				sortArray[k] = helpArray[j];
				j++;
				count++;
			}
			k++;
		}
		while (i <= mid) {
			sortArray[k] = helpArray[i];
			k++;
			i++;
			count++;
		}
	}

	/*********************************************************************
	 * Funktion liest eine Datei mit Werten ein und speichert sie in einem
	 * int-Array
	 * 
	 * @param file - Die einzulesene Datei mit den Werten für das Array
	 * @return Die Elemente aus der Datei in einem int-Array
	 *********************************************************************/
	public static int[] readArray(String file) {
		int anzahl = 0;
		try {
			Scanner scanLaenge = new Scanner(new File(file));
			while (scanLaenge.hasNextLine()) {
				anzahl++;
				scanLaenge.nextLine();
			}
			int[] elemente = new int[anzahl];

			Scanner scanContent = new Scanner(new File(file));
			for (int i = 0; i < anzahl; i++) {
				elemente[i] = scanContent.nextInt();
			}
			return elemente;

		} catch (FileNotFoundException e) {
			System.out.println("Die Datei konnte nicht gefunden werden!");
			e.printStackTrace();
		}
		return null;

	}
}
