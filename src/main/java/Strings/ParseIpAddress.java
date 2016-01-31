package Strings;

/**
 * Created by sarvothampai on 19/01/16.
 *
 * ((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)
 *
 *
 * ^	Start of a string.
 $	End of a string.
 .	Any character (except \n newline)
 |	Alternation.
 {...}	Explicit quantifier notation.
 [...]	Explicit set of characters to match.
 (...)	Logical grouping of part of an expression.
 *	0 or more of previous expression.
 +	1 or more of previous expression.
 ?	0 or 1 of previous expression; also forces minimal matching when an expression might match several strings within a search string.
 \	Preceding one of the above, it makes it a literal instead of a special character. Preceding a special matching character, see below.

 grep -E -w -o “((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)” test.txt
 *
 *
 */
public class ParseIpAddress {
}
