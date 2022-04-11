library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity periferico_completo is
    Port ( reset : in STD_LOGIC;
           clk : in STD_LOGIC;
           load_tx : in STD_LOGIC;
           data_tx : in STD_LOGIC_VECTOR (7 downto 0);
           MISO : in STD_LOGIC;
           sclk : out STD_LOGIC;
           data_rx : out STD_LOGIC_VECTOR (7 downto 0);
           MOSI : out STD_LOGIC;
           tx_rx_end : out STD_LOGIC;
           SS        : out STD_LOGIC;
           buffer_empty : out STD_LOGIC);
end periferico_completo;

architecture Behavioral of periferico_completo is

COMPONENT unidad_control
   Port (
      FA        :  in  std_logic;
      FD        :  in  std_logic;
      clk       :  in  std_logic;
      overflow  :  in  std_logic;
      reset     :  in  std_logic;
      salida_rs   :  in  std_logic;
      reset_cont :  out  std_logic;
      SS         :  out  std_logic;
      ce_CONTADOR : out std_logic;
      ce_MISO    :  out  std_logic;
      ce_MOSI    :  out  std_logic;
      ce_DIVISOR : out std_logic;
      load_rx    :  out  std_logic;
      tx_rx_end  :  out  std_logic;
      load_MOSI  :  out  std_logic;
      reset_rs   : out std_logic
   );
end COMPONENT;

COMPONENT unidad_operativa
   Port (
      clk           : in  std_logic;
      reset         : in std_logic;
      reset_cont    : in std_logic;
      reset_rs      : in std_logic;
      load_tx       : in  std_logic;
      load_rx       : in  std_logic;
      load_MOSI     : in  std_logic;
      MISO          : in  std_logic;
      ce_CONTADOR   : in  std_logic;
      ce_MOSI       : in  std_logic;
      data_tx       : in  std_logic_vector(7 downto 0);
      ce_MISO       : in  std_logic;
      ce_DIVISOR    : in std_logic;      
      MOSI          : out  std_logic;
      overflow      : inout  std_logic;
      FA            : out std_logic;
      FD            : out std_logic;
      sclk          : out  std_logic;
      data_rx       : out  std_logic_vector(7 downto 0);
      buffer_empty  : out std_logic;
      salida_rs     : out std_logic
   );
end COMPONENT;

    signal overflow : STD_LOGIC := '0';
    signal reset_cont : std_logic:='0';
    signal ce_CONTADOR : STD_LOGIC := '0';
    signal ce_MISO : STD_LOGIC := '0';
    signal ce_MOSI : STD_LOGIC := '0';
    signal FA : STD_LOGIC := '0';
    signal FD : STD_LOGIC := '0';
    signal reset_rs : STD_LOGIC := '0';
    signal salida_rs : std_logic := '0';
    signal load_rx : STD_LOGIC := '0';
    signal load_MOSI : STD_LOGIC := '0';
    signal ce_DIVISOR : STD_LOGIC :='0';
    

begin

UC: unidad_control
   PORT MAP (
      FA        => FA,
      FD        => FD,
      reset     => reset,  
      overflow  => overflow, 
      clk       => clk,
      salida_rs   => salida_rs,
      reset_cont => reset_cont,
      ce_CONTADOR   => ce_CONTADOR, 
      ce_MISO   => ce_MISO,
      ce_MOSI   => ce_MOSI,  
      load_rx   => load_rx,      
      tx_rx_end => tx_rx_end,
      load_MOSI  => load_MOSI,
      ce_DIVISOR => ce_DIVISOR,
      SS => SS,
      reset_rs  => reset_rs
   );

UOP: unidad_operativa
   PORT MAP (
    clk => clk,
    reset => reset,
    reset_cont => reset_cont,
    load_tx => load_tx,
    load_rx => load_rx,
    load_MOSI => load_MOSI,
    MISO => MISO,
    ce_CONTADOR => ce_CONTADOR,
    ce_MOSI => ce_MOSI,
    data_tx => data_tx,
    ce_MISO => ce_MISO,
    ce_DIVISOR => ce_DIVISOR,
    MOSI => MOSI,
    overflow => overflow,
    FA => FA,
    FD => FD,
    sclk => sclk,
    data_rx => data_rx,
    buffer_empty => buffer_empty,
    reset_rs => reset_rs,
    salida_rs => salida_rs
   );
end Behavioral;