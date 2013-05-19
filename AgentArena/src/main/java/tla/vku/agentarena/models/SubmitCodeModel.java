package tla.vku.agentarena.models;

public class SubmitCodeModel {
	
	private String code;
	private String compilationErrors;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCompilationErrors() {
		return compilationErrors;
	}
	public void setCompilationErrors(String compilationErrors) {
		this.compilationErrors = compilationErrors;
	}
}
