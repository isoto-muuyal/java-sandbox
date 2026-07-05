package com.iss.MyEnums;

public enum Status {
        STARTED,
        IN_PROGRESS,
        FINISHED;

        public Status next() {
            switch (this) {
                case STARTED: return IN_PROGRESS;
                case IN_PROGRESS: return FINISHED;
                default: return FINISHED;
            }
        }
}
