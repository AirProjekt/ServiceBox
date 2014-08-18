package hr.box.mobile.domain;

import java.util.List;

public class OcjeneGrid {
	
	private int totalPages;
	
	private int currentPage;
	
	private long totalRecords;
	
	private List<Ocjene> ocjeneData;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<Ocjene> getOcjeneData() {
		return ocjeneData;
	}

	public void setOcjeneData(List<Ocjene> ocjeneData) {
		this.ocjeneData = ocjeneData;
	}
	
}
