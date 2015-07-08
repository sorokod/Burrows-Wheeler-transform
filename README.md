# A Burrows–Wheeler transform implementation

This is a Java implementation of [BWT](https://en.wikipedia.org/wiki/Burrows%E2%80%93Wheeler_transform ). The implementation follows the description given in [this](https://www.youtube.com/watch?v=4n7NPk5lwbI) video. The encoding and decoding logic requires an `EOF` character which must be the last character in the input for encoding such that it's value is less then all other characters in the input. The "minimal" character `\u0000` is a good choice.
Alternatively, the `$` character can be used for testing as it has a low numeric value and is easily recognizable, e.g: `abaaba$` encodes to `abba$aa`

### Comments
* The implementation is using the suffix aray approach for encoding 
* Thread safe (Encoder and Decoder are stateless)
* Reasonably efficient
* The tests in test/ directory demonstrate the basic usage

