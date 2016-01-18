package de.htwg.se.texasholdem.model;

public enum Suit {
	
	SPACE {
		@Override
		public String toString() {
			return "\u2660";
		}
	},
	DIAMOND {
		@Override
		public String toString() {
			return "\u2666";
		}
	},
	HEART {
		@Override
		public String toString() {
			return "\u2665";
		}
	},
	CLUB {
		@Override
		public String toString() {
			return "\u2663";
		}
	}

}
