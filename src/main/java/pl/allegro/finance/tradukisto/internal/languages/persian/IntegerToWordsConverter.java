package pl.allegro.finance.tradukisto.internal.languages.persian;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import pl.allegro.finance.tradukisto.internal.GenderAwareIntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;

/**
 * @author omidp
 *
 */
public class IntegerToWordsConverter extends pl.allegro.finance.tradukisto.internal.converters.IntegerToWordsConverter
{

    private final List<PluralForms> pluralForms;
    
    public IntegerToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter, List<PluralForms> pluralForms)
    {
        super(hundredsToWordsConverter, pluralForms);
        this.pluralForms = pluralForms;
    }

    public IntegerToWordsConverter(IntegerToStringConverter hundredsToWordsConverter, List<PluralForms> pluralForms)
    {
        super(hundredsToWordsConverter, pluralForms);
        this.pluralForms = pluralForms;
    }
    
    
    @Override
    protected String joinParts(List<String> result)
    {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType());
        }
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (String item : result)
        {
            if(item != null && item.trim().length() > 0)
            {
                if(counter > 1)
                {
                    Iterable<String> split = Splitter.on(" ").split(item);
                    for (Iterator iterator = split.iterator(); iterator.hasNext();)
                    {                    
                        sb.append(" \u0648 ");
                        String string = (String) iterator.next();
                        sb.append(string);                        
                    }
                }
                else
                    sb.append(item).append(" ");
            }
            counter++;
        }
//        return Joiner.on(" ").join(result).trim();
        return sb.toString();
    }

}
