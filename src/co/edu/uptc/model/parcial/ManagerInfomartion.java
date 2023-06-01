package co.edu.uptc.model.parcial;

public class ManagerInfomartion {

    private figureInformation figureInformations;
    private panelInformation panelInformations;
    private frameInformation frameInformations;

    public ManagerInfomartion(){
        figureInformations = new figureInformation();
        panelInformations = new panelInformation();
        frameInformations = new frameInformation();
    }

    public figureInformation getFigureInformations() {
        return figureInformations;
    }

    public void setFigureInformations(figureInformation figureInformations) {
        this.figureInformations = figureInformations;
    }

    public panelInformation getPanelInformations() {
        return panelInformations;
    }

    public void setPanelInformations(panelInformation panelInformations) {
        this.panelInformations = panelInformations;
    }

    public frameInformation getFrameInformations() {
        return frameInformations;
    }

    public void setFrameInformations(frameInformation frameInformations) {
        this.frameInformations = frameInformations;
    }
}
