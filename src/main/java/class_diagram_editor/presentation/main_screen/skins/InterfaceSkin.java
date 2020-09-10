package class_diagram_editor.presentation.main_screen.skins;

import de.tesis.dynaware.grapheditor.GConnectorSkin;
import de.tesis.dynaware.grapheditor.GNodeSkin;
import de.tesis.dynaware.grapheditor.model.GNode;
import javafx.geometry.Point2D;

import java.util.List;

public class InterfaceSkin extends GNodeSkin {
    public InterfaceSkin(GNode node) {
        super(node);
    }

    @Override
    public void setConnectorSkins(List<GConnectorSkin> connectorSkins) {

    }

    @Override
    public void layoutConnectors() {

    }

    @Override
    public Point2D getConnectorPosition(GConnectorSkin connectorSkin) {
        return null;
    }

    @Override
    protected void selectionChanged(boolean isSelected) {

    }
}
