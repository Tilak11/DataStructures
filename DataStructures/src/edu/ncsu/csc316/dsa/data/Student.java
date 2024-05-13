package edu.ncsu.csc316.dsa.data;

/**
 * A student is comparable and identifiable. Students have a first name, last
 * name, id number, number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	/** Student's first name */
	private String first;
	/** Student's last name */
	private String last;
	/** Student's id */
	private int id;
	/** Student's credit hours */
	private int creditHours;
	/** Student's gpa */
	private double gpa;
	/** Student's unityid */
	private String unityID;

	/**
	 * Student constructor
	 * 
	 * @param first       first name
	 * @param last        last name
	 * @param id          student id
	 * @param creditHours credit hours a student is taking
	 * @param gpa         student's gpa
	 * @param unityID     student's unity id
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}

	/**
	 * Getter for first name
	 * 
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Setter for first name
	 * 
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Getter for last name
	 * 
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Setter for last name
	 * 
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Getter for student id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for student id
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for for credit hours
	 * 
	 * @return the creditHours
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * Setter for credit hours
	 * 
	 * @param creditHours the creditHours to set
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Getter for gpa
	 * 
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Setter for gpa
	 * 
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Getter for unityID
	 * 
	 * @return the unityID
	 */
	public String getUnityID() {
		return unityID;
	}

	/**
	 * Setter for unityID
	 * 
	 * @param unityID the unityID to set
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditHours;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((unityID == null) ? 0 : unityID.hashCode());
		return result;
	}

	@Override
	public int compareTo(Student o) {
		int d = this.getLast().compareToIgnoreCase(o.getLast());
		if (d == 0) {
			d = this.getFirst().compareToIgnoreCase(o.getFirst());
		}
		if (d == 0) {
			if (this.getId() > o.getId())
				d = 1;
			else if (this.getId() < o.getId())
				d = -1;
			else
				d = 0;

		}
		return d;
	}

	/**
	 * Two students are equal if they have same first name, last name and student id
	 * 
	 * @param obj student to be compared with this
	 * @return true if two students are equal
	 */
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		if (this.first.equalsIgnoreCase(other.getFirst()) && this.last.equalsIgnoreCase(other.getLast())
				&& this.id == other.getId())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return first + "," + last + "," + id + "," + creditHours + "," + gpa + "," + unityID;
	}

}
