package Pruefungsuebungen.Pruefung_Musikanten_1.testprogramme.junittest;

//
//public class PruefungTest {
//	
//	//toString Methoden werden nicht geprueft
//	
//	@Test
//	public void testEsel() {
//		Instrument i = new Instrument("Trompete", 20.5); 
//		Esel e = new Esel(4, i, 30.2);
//		
//		assertEquals(4, e.getAnzahlBeine());
//		assertEquals(i, e.getInstrument());
//		assertEquals(30.2, e.getTrittkraft(), 0.001);
//		assertEquals(20.5, e.getInstrument().getLautstaerke(), 0.001);
//		assertEquals("Trompete", e.getInstrument().getName());
//		
//		assertEquals(20.5, e.spieleMusik(), 0.001);
//		assertEquals(120, e.verscheucheRaeuber());		
//		
//	}
//	@Test
//	public void testKatze() {
//		Instrument i = new Instrument("Trompete", 20.5); 
//		Katze e = new Katze(4, i, 30.2);
//		Katze e3 = new Katze(3, i, 30.2);
//		Katze e2 = new Katze(2, i, 30.2);
//		Katze e1 = new Katze(1, i, 30.2);
//		
//		assertEquals(4, e.getAnzahlBeine());
//		assertEquals(i, e.getInstrument());
//		assertEquals(30.2, e.getKratzKraft(), 0.001);
//		assertEquals(20.5, e.getInstrument().getLautstaerke(), 0.001);
//		assertEquals("Trompete", e.getInstrument().getName());
//		
//		assertEquals(20.5, e.spieleMusik(), 0.001);
//		assertEquals(30, e.verscheucheRaeuber());
//		assertEquals(15, e3.verscheucheRaeuber());
//		assertEquals(1, e2.verscheucheRaeuber());
//		assertEquals(1, e1.verscheucheRaeuber());
//		
//	}
//	@Test
//	public void testHund() {
//		Instrument i = new Instrument("Trompete", 20.5); 
//		Hund e = new Hund(4, i, 30.2);
//		Hund el = new Hund(3, i, 10.2);
//		
//		assertEquals(4, e.getAnzahlBeine());
//		assertEquals(i, e.getInstrument());
//		assertEquals(30.2, e.getBellLautstaerke(), 0.001);
//		assertEquals(20.5, e.getInstrument().getLautstaerke(), 0.001);
//		assertEquals("Trompete", e.getInstrument().getName());
//		
//		assertEquals(25.35, e.spieleMusik(), 0.001);
//		assertEquals(15.35, el.spieleMusik(), 0.001);
//		assertEquals(30, e.verscheucheRaeuber());
//		assertEquals(20, el.verscheucheRaeuber());
//		
//	}
//	@Test
//	public void testHahn() {
//		Instrument i = new Instrument("Trompete", 20.5); 
//		Hahn e = new Hahn(4, i, 1);
//		Hahn e2 = new Hahn(3, i, 2);
//		Hahn e3 = new Hahn(2, i, 3);
//		Hahn e4 = new Hahn(1, i, 4);
//		Hahn e5 = new Hahn(1, i, 5);
//		Hahn e6 = new Hahn(1, i, 6);
//		Hahn e7 = new Hahn(1, i, 7);
//		
//		assertEquals(4, e.getAnzahlBeine());
//		assertEquals(i, e.getInstrument());
//		assertEquals(1, e.getFlugWeite());
//		assertEquals(20.5, e.getInstrument().getLautstaerke(), 0.001);
//		assertEquals("Trompete", e.getInstrument().getName());
//		
//		assertEquals(22.5, e.spieleMusik(), 0.001);
//		assertEquals(7.5, e3.spieleMusik(), 0.001);
//		assertEquals(1, e7.verscheucheRaeuber());
//		assertEquals(2, e6.verscheucheRaeuber());
//		assertEquals(3, e5.verscheucheRaeuber());
//		assertEquals(4, e4.verscheucheRaeuber());
//		assertEquals(5, e3.verscheucheRaeuber());
//		assertEquals(6, e2.verscheucheRaeuber());
//		assertEquals(20, e.verscheucheRaeuber());
//	}
//	@Test
//	public void testQuartett() {
//		Instrument i = new Instrument("Trompete", 20.5); 
//		Esel e = new Esel(4, i, 10.2);
//		Katze k = new Katze(4, i, 28.2);
//		Hund hu = new Hund(4, i, 30.2);
//		Hahn ha = new Hahn(2, i, 1);
//		
//		Quartett q = new Quartett();
//		q.add(e);
//		q.add(k);
//		q.add(hu);
//		
//		assertFalse(q.istQuartett());
//		q.add(ha);
//		assertTrue(q.istQuartett());
//		
//		assertEquals(118, q.gemeinsamRaeuberVerscheucht());
//		assertEquals(22.2125, q.durchschnittlicheLautstaerke(), 0.00001);
//		
//		ArrayList<Musikant> m = q.getMusikantenInLautstaerkeBereich(20, 21);
//		assertEquals(2, m.size());
//		assertTrue(m.contains(e));
//		assertTrue(m.contains(k));
//		
//		HashMap<Integer, Integer> hm = q.getAnzahlMusikantenMitBeinAnzahl();
//		
//		assertEquals(2, hm.size());
//		assertTrue(hm.containsKey(2));
//		assertTrue(hm.containsKey(4));
//		assertEquals(1, (int)hm.get(2));
//		assertEquals(3, (int)hm.get(4));
//		
//	}
//	
//	@Test
//	public void testComparator() {
//		LautstaerkeComparator lc = new LautstaerkeComparator();
//		
//		Musikant []alle = new Musikant[4];
//		
//		Instrument i = new Instrument("Trompete", 10.5);
//		Instrument i2 = new Instrument("Trompete", 12.5);
//		Instrument i3 = new Instrument("Trompete", 11.5);
//		Instrument i4 = new Instrument("Trompete", 13.5);
//		Hahn e = new Hahn(4, i, 1);
//		Hahn e2 = new Hahn(3, i2, 1);
//		Hahn e3 = new Hahn(2, i3, 1);
//		Hahn e4 = new Hahn(1, i4, 1);
//		
//		alle[0] = e;
//		alle[1] = e2;
//		alle[2] = e3;
//		alle[3] = e4;
//		
//		
//		assertEquals(e, alle[0]);
//		assertEquals(e2, alle[1]);
//		assertEquals(e3, alle[2]);
//		assertEquals(e4, alle[3]);
//		
//		Arrays.sort(alle, lc);
//
//		assertEquals(e4, alle[0]);
//		assertEquals(e2, alle[1]);
//		assertEquals(e3, alle[2]);
//		assertEquals(e, alle[3]);
//
//	}
//}
