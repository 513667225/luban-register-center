package cloud;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.event.EventListener;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class Test implements ImportSelector {

    @EventListener
    public void test(InstanceRegisterEvent instanceRegisterEvent){
        //..记录数据...
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
