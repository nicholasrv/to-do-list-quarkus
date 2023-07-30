package converters;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter(forClass = Date.class)
public class DateConverter implements Converter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.format((Date) value);
        }
        return null;
    }
}
