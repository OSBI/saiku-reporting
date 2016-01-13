package bi.meteorite.saiku.reporting.metadata.repository;

import bi.meteorite.saiku.reporting.metadata.repository.model.MetadataModelInfoImpl;

import java.util.Comparator;

public class ModelInfoComparator implements Comparator {
    public ModelInfoComparator() {
    }

    public int compare(Object obj1, Object obj2) {
      MetadataModelInfoImpl model1 = (MetadataModelInfoImpl)obj1;
      MetadataModelInfoImpl model2 = (MetadataModelInfoImpl)obj2;
      return model1.getModelId().compareTo(model2.getModelId());
    }
  }
