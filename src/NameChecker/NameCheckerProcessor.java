package NameChecker;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckerProcessor extends AbstractProcessor {
    private NameChecker nameChekcer;

    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChekcer = new NameChecker(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(!roundEnv.processingOver()) {
            for(Element element : roundEnv.getRootElements()) {
                nameChekcer.checkNames(element);
            }
        }
        return false;
    }
}
