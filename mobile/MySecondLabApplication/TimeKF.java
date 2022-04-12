// 
// Decompiled by Procyon v0.5.36
// 


import java.util.Calendar;
import java.util.Date;

public class TimeKF {
    private long hours;
    private long minutes;
    private long seconds;

    long getHours() {
        return this.hours;
    }

    void setHours(final long hours) {
        if (hours >= 0L & hours < 24L) {
            this.hours = hours;
            return;
        }
        throw new ExceptionInInitializerError("Please see your hours");
    }

    long getMinutes() {
        return this.minutes;
    }

    void setMinutes(final long minutes) {
        if (minutes >= 0L & minutes < 60L) {
            this.minutes = minutes;
            return;
        }
        throw new ExceptionInInitializerError("Please see your minutes");
    }

    long getSeconds() {
        return this.seconds;
    }

    void setSeconds(final long seconds) {
        if (seconds >= 0L & seconds < 60L) {
            this.seconds = seconds;
            return;
        }
        throw new ExceptionInInitializerError("Please see your seconds");
    }

    TimeKF() {
        this.setHours(0L);
        this.setMinutes(0L);
        this.setSeconds(0L);
    }

    TimeKF(final long hours, final long minutes, final long seconds) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    TimeKF(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.setHours(calendar.get(11));
        this.setMinutes(calendar.get(12));
        this.setSeconds(calendar.get(13));
    }

    @Override
    public String toString() {
        String output = "";
        if (this.hours < 10L) {
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String;)Ljava / lang / String;,output);
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String; J)Ljava / lang / String;,
            output, this.hours);
        } else {
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String; J)Ljava / lang / String;,
            output, this.hours);
        }
        output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String;)Ljava / lang / String;,output);
        if (this.minutes < 10L) {
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String;)Ljava / lang / String;,output);
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String; J)Ljava / lang / String;,
            output, this.minutes);
        } else {
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String; J)Ljava / lang / String;,
            output, this.minutes);
        }
        output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String;)Ljava / lang / String;,output);
        if (this.seconds < 10L) {
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String;)Ljava / lang / String;,output);
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String; J)Ljava / lang / String;,
            output, this.seconds);
        } else {
            output = invokedynamic(makeConcatWithConstants:(Ljava / lang / String; J)Ljava / lang / String;,
            output, this.seconds);
        }
        return output;
    }

    private static TimeKF _add(final TimeKF first, final TimeKF second) {
        long seconds = 0L;
        long minutes = 0L;
        long hours = 0L;
        final long currentSeconds = first.seconds + second.seconds;
        if (currentSeconds >= 60L) {
            ++minutes;
            seconds = currentSeconds - 60L;
        } else {
            seconds = currentSeconds;
        }
        final long currentMinutes = minutes + first.minutes + second.minutes;
        if (currentMinutes >= 60L) {
            ++hours;
            minutes = currentMinutes - 60L;
        } else {
            minutes = currentMinutes;
        }
        final long currentHours = hours + first.hours + second.hours;
        if (currentHours >= 24L) {
            hours = currentHours - 24L;
        } else {
            hours = currentHours;
        }
        return new TimeKF(hours, minutes, seconds);
    }

    private static TimeKF _substract(final TimeKF first, final TimeKF second) {
        long hours = 0L;
        long minutes = 0L;
        long seconds = 0L;
        boolean minusSecond = false;
        if (first.hours == 0L & first.minutes == 0L & first.seconds == 0L) {
            first.setHours(23L);
            first.setMinutes(59L);
            first.setSeconds(59L);
            minusSecond = true;
        }
        final long currentHours = first.hours - second.hours;
        if (currentHours >= 0L) {
            hours = currentHours;
            final long currentMinutes = first.minutes - second.minutes;
            if (currentMinutes >= 0L) {
                minutes = currentMinutes;
            } else {
                --hours;
                minutes = first.minutes + 60L - second.minutes;
            }
            final long currentSeconds = first.seconds - second.seconds;
            if (currentSeconds >= 0L) {
                seconds = currentSeconds;
            } else {
                --minutes;
                seconds = first.seconds + 60L - second.seconds;
            }
            if (minusSecond) {
                ++seconds;
            }
            return new TimeKF(hours, minutes, seconds);
        }
        throw new ArithmeticException("Hours out of bound exception");
    }

    public TimeKF add(final TimeKF term) {
        return _add(this, term);
    }

    public TimeKF substract(final TimeKF substracted) {
        return _substract(this, substracted);
    }

    public static TimeKF addTwoObjects(final TimeKF first, final TimeKF second) {
        return _add(first, second);
    }

    public static TimeKF substractTwoObjects(final TimeKF first, final TimeKF second) {
        return _substract(first, second);
    }

    public static void main(String[] args) {
        final TimeKF firstTime = new TimeKF(12L, 0L, 1L);
        final TimeKF secondTime = new TimeKF(12L, 0L, 1L);
        final TimeKF thirdTime = new TimeKF(new Date(10, 12, 2003, 23, 59, 59));
        System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, thirdTime.toString()));
        System.out.println(invokedynamic(makeConcatWithConstants:(Lcom/company/TimeKF;)Ljava/lang/String;, secondTime.add(thirdTime)));
        System.out.println(invokedynamic(makeConcatWithConstants:(Lcom/company/TimeKF;)Ljava/lang/String;, new TimeKF(0L, 0L, 0L).substract(new TimeKF(0L, 0L, 1L))));
        System.out.println(invokedynamic(makeConcatWithConstants:(Lcom/company/TimeKF;)Ljava/lang/String;, addTwoObjects(new TimeKF(10L, 10L, 10L), new TimeKF(10L, 30L, 30L))));
        System.out.println(invokedynamic(makeConcatWithConstants:(Lcom/company/TimeKF;)Ljava/lang/String;, substractTwoObjects(new TimeKF(20L, 10L, 10L), new TimeKF(10L, 50L, 5L))));
    }
}
