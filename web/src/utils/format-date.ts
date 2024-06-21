
export default function FormatDate( date : string)
{
    const post_date = new Date(date);
    const options: Intl.DateTimeFormatOptions = {
        year: "numeric",
        month: "long",
        day: "numeric"
    };
    return post_date.toLocaleDateString("en-US", options);
}