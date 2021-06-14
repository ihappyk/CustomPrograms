package com.ihappyk.ariba;

import java.util.*;
import java.util.stream.Collectors;

class AuditChange {
    private String key;
    private String oldValue;
    private String newValue;

    public AuditChange ()
    {
    }

    public AuditChange (String key, String oldValue, String newValue)
    {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getOldValue ()
    {
        return oldValue;
    }

    public void setOldValue (String oldValue)
    {
        this.oldValue = oldValue;
    }

    public String getNewValue ()
    {
        return newValue;
    }

    public void setNewValue (String newValue)
    {
        this.newValue = newValue;
    }

    @Override public String toString ()
    {
        return "AuditChange{" + "key='" + key + '\'' + ", oldValue='" + oldValue + '\''
            + ", newValue='" + newValue + '\'' + '}';
    }
}

class AuditAttribute {
    private String key;
    private String value;

    public AuditAttribute (String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AuditAttribute that = (AuditAttribute)o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash(key, value);
    }

    @Override
    public String toString ()
    {
        return "AuditAttribute{" + "key='" + key + '\'' + ", value='" + value + '\''
            + '}';
    }
}

public class SetImplementation
{
    public static void main(String args[]) {
        Set<AuditAttribute> oldAuditSet = new HashSet<AuditAttribute>();

        oldAuditSet.add(new AuditAttribute("name", "Santhosh"));
        oldAuditSet.add(new AuditAttribute("age", "29"));
        oldAuditSet.add(new AuditAttribute("gender", "M"));
        oldAuditSet.add(new AuditAttribute("religion", "Indian"));

        Set<AuditAttribute> newAuditSet = new HashSet<AuditAttribute>();

        newAuditSet.add(new AuditAttribute("name","Abhishek"));
        newAuditSet.add(new AuditAttribute("age","31"));
        newAuditSet.add(new AuditAttribute("gender","M"));
        newAuditSet.add(new AuditAttribute("religion","Indian"));

        Set<AuditAttribute> diffSet = auditDiff(oldAuditSet,newAuditSet);
        System.out.println(diffSet.toString());

        auditChanges(diffSet,oldAuditSet,newAuditSet);

    }


    public static Set<AuditAttribute> auditDiff(Set<AuditAttribute> oldAuditedSet, Set<AuditAttribute> newAuditedSet)
    {
        Set<AuditAttribute> resultSet = new HashSet<AuditAttribute>(oldAuditedSet);
        // remove  newFields that are same in oldAuditSet
        resultSet.removeAll(newAuditedSet);

        // same as above
        newAuditedSet.removeAll(oldAuditedSet);

        resultSet.addAll(newAuditedSet);

        return resultSet;
    }

    public static void auditChanges (Set<AuditAttribute> diffSet,
                                     Set<AuditAttribute> oldAuditedSet,
                                     Set<AuditAttribute> newAuditedSet)
    {
        Set<AuditChange> auditChangeSet = new HashSet<AuditChange>();
        Set<String> keys = diffSet.stream()
            .map(AuditAttribute::getKey)
            .collect(Collectors.toSet());
        if (null != diffSet && diffSet.size() > 0) {
            for(String s: keys) {
                AuditChange change = new AuditChange();
                change.setKey(s);
                /*AuditAttribute oldAttr = oldAuditedSet.stream()
                    .filter(attr -> s.equals(attr.getKey()))
                    .findAny()
                    .orElse(null);
                AuditAttribute newAttr = newAuditedSet.stream()
                    .filter(attr -> s.equals(attr.getKey()))
                    .findAny()
                    .orElse(null);

                change.setOldValue(oldAttr != null ? oldAttr.getValue() : "");
                change.setNewValue(newAttr != null ? newAttr.getValue() : "");
                */
                change.setOldValue(getValueFromAttribute(s,oldAuditedSet));
                change.setNewValue(getValueFromAttribute(s,newAuditedSet));
                auditChangeSet.add(change);
            }
        }
        System.out.println(auditChangeSet.toString());
    }

    public static String getValueFromAttribute(String key, Set<AuditAttribute> auditAttributeSet)
    {
        AuditAttribute auditAttr = auditAttributeSet.stream()
            .filter(attr -> key.equals(attr.getKey()))
            .findAny()
            .orElse(null);
        return auditAttr != null ? auditAttr.getValue() : "";
    }
}
