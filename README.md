# A Burrows–Wheeler transform implementation

This is a Java implementation of [BWT](https://en.wikipedia.org/wiki/Burrows%E2%80%93Wheeler_transform ). The implementation follows the description given in [this](https://www.youtube.com/watch?v=4n7NPk5lwbI) video. The encoding and decoding logic requires a "terminator" character which must be the last character in the input for encoding such that it's value is less then all other characters in the input. By default this is `\u0000`.  For example `"SIX.MIXED.PIXIES.SIFT.SIXTY.PIXIE.DUST.BOXES"` will encode to `"TEXYDST.E.IXIXIXXSSMPPS.B..E.\u0000.EUSFXDIIOIIIT"` 

### Comments
* The implementation is using the suffix aray approach for encoding 
* Thread safe (Encoder and Decoder are stateless)
* Reasonably efficient
* The test directory contains tests that demonstrate the basic usage

