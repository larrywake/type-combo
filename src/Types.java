
public abstract class Types {
	
	/* 00 Normal
	 * 01 Fighting
	 * 02 Flying
	 * 03 Poison
	 * 04 Ground
	 * 05 Rock
	 * 06 Bug
	 * 07 Ghost
	 * 08 Steel
	 * 09 Fire
	 * 10 Water
	 * 11 Grass
	 * 12 Electric
	 * 13 Psychic
	 * 14 Ice
	 * 15 Dragon
	 * 16 Dark 
	 * 17 Fairy */
	
	public static final double[][] chart =
					/*00  01  02  03  04  05  06  07  08  09  10  11  12  13  14  15  16  17*/
			/*00*/ {{  1,  1,  1,  1,  1, .5,  1,  0, .5,  1,  1,  1,  1,  1,  1,  1,  1,  1},
			/*01*/	{  2,  1, .5, .5, .5,  2, .5,  0,  2,  1,  1,  1,  1, .5,  2,  1,  2, .5},
			/*02*/	{  1,  2,  1,  1,  1, .5,  2,  1, .5,  1,  1,  2, .5,  1,  1,  1,  1,  1},
			/*03*/	{  1,  1,  1, .5, .5, .5,  1, .5,  0,  1,  1,  2,  1,  1,  1,  1,  1,  2},
			/*04*/	{  1,  1,  0,  2,  1,  2, .5,  1,  2,  2,  1, .5,  2,  1,  1,  1,  1,  1},
			/*05*/	{  1, .5,  2,  1, .5,  1,  2,  1, .5,  2,  1,  1,  1,  1,  2,  1,  1,  1},
			/*06*/	{  1, .5, .5, .5,  1,  1,  1, .5, .5, .5,  1,  2,  1,  2,  1,  1,  2, .5},
			/*07*/	{  0,  1,  1,  1,  1,  1,  1,  2,  1,  1,  1,  1,  1,  2,  1,  1, .5,  1},
			/*08*/	{  1,  1,  1,  1,  1,  2,  1,  1, .5, .5, .5,  1, .5,  1,  2,  1,  1,  2},
			/*09*/	{  1,  1,  1,  1,  1, .5,  2,  1,  2, .5, .5,  2,  1,  1,  2, .5,  1,  1},
			/*10*/	{  1,  1,  1,  1,  2,  2,  1,  1,  1,  2, .5, .5,  1,  1,  1, .5,  1,  1},
			/*11*/	{  1,  1, .5, .5,  2,  2, .5,  1, .5, .5,  2, .5,  1,  1,  1, .5,  1,  1},
			/*12*/	{  1,  1,  2,  1,  0,  1,  1,  1,  1,  1,  2, .5, .5,  1,  1, .5,  1,  1},
			/*13*/	{  1,  2,  1,  2,  1,  1,  1,  1, .5,  1,  1,  1,  1, .5,  1,  1,  0,  1},
			/*14*/	{  1,  1,  2,  1,  2,  1,  1,  1, .5, .5, .5,  2,  1,  1, .5,  2,  1,  1},
			/*15*/	{  1,  1,  1,  1,  1,  1,  1,  1, .5,  1,  1,  1,  1,  1,  1,  1,  1,  0},
			/*16*/	{  1, .5,  1,  1,  1,  1,  1,  2,  1,  1,  1,  1,  1,  2,  1,  1, .5, .5},
			/*17*/	{  1,  2,  1, .5,  1,  1,  1,  1, .5, .5,  1,  1,  1,  1,  1,  2,  2,  1}};
			
}
