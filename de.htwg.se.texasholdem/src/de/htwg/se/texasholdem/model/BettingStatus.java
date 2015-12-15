package de.htwg.se.texasholdem.model;

public enum BettingStatus {
	PRE_FLOP {
		@Override
		public String toString() {
			return "Pre Flop";
		}
	},
	FLOP {
		@Override
		public String toString() {
			return "Flop";
		}
	},
	TURN {
		@Override
		public String toString() {
			return "Turn";
		}
	},
	RIVER {
		@Override
		public String toString() {
			return "River";
		}
	},
	SHOWDOWN {
		@Override
		public String toString() {
			return "Showdown";
		}
	}
}
