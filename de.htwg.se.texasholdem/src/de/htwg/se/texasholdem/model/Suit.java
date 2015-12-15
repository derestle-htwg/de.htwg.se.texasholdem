package de.htwg.se.texasholdem.model;

public enum Suit {
	
	SPACE {
		@Override
		public String toString() {
			return "S";
		}
	},
	DIAMOND {
		@Override
		public String toString() {
			return "D";
		}
	},
	HEART {
		@Override
		public String toString() {
			return "H";
		}
	},
	CLUB {
		@Override
		public String toString() {
			return "C";
		}
	}

}
