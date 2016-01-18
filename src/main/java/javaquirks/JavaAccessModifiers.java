package javaquirks;

/**
 * Created by sarvothampai on 15/01/16.
 *
 * The following table shows the access to members permitted by each modifier.

 Access Levels
 Modifier	Class	Package	Subclass	World
 public	Y	Y	Y	Y
 protected	Y	Y	Y	N
 no modifier	Y	Y	N	N
 private	Y	N	N	N


 The first data column indicates whether the class itself has access to the member defined by the access level.
 As you can see, a class always has access to its own members.
 The second column indicates whether classes in the same package as the class (regardless of their parentage) have access to the member.

 */
public class JavaAccessModifiers {
}
