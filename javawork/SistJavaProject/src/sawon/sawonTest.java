package sawon;

import java.util.List;

import sawon.domain.Sawon;
import sawon.respository.SawonRepository;

public class sawonTest {
	public static void main(String[] args) {
		SawonRepository sr = new SawonRepository();
		
		List<Sawon> sawons =  sr.findAll(1);
		for (Sawon sawon : sawons) {
			System.out.println(sawon.getName());
		}
	}
}
